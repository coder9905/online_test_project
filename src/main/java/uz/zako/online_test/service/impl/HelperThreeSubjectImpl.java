package uz.zako.online_test.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.zako.online_test.entity.Subject;
import uz.zako.online_test.entity.helper.HelperThreeSubject;
import uz.zako.online_test.exception.ResourceNotFoundException;
import uz.zako.online_test.model.Result;
import uz.zako.online_test.payload.HelperSubjectThreePayload;
import uz.zako.online_test.repository.HelperSecondSubjectRepository;
import uz.zako.online_test.repository.HelperThreeSubjectRepository;
import uz.zako.online_test.repository.SubjectRepository;
import uz.zako.online_test.service.HelperThreeSubjectService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class HelperThreeSubjectImpl implements HelperThreeSubjectService {

    private final SubjectRepository subjectRepository;
    private final HelperSecondSubjectRepository helperSecondSubjectRepository;
    private final HelperThreeSubjectRepository helperThreeSubjectRepository;

    @Override
    public ResponseEntity<?> saveHelperThreeSubject(HelperSubjectThreePayload payload){

        try {
            List<HelperThreeSubject> helperThreeSubjects=new ArrayList<>();

            List<Subject> subjectList=subjectRepository.findAllById(payload.getSubjectId());

            for (int i = 0; i < subjectList.size(); i++) {

                HelperThreeSubject helperThreeSubject=new HelperThreeSubject();
                helperThreeSubject.setHelperSecondSubject(helperSecondSubjectRepository.findById(payload.getHelperSubjectSecondId()).get());
                helperThreeSubject.setSubject(subjectList.get(i));
                helperThreeSubjects.add(helperThreeSubjectRepository.save(helperThreeSubject));

            }

            if (helperThreeSubjects.size() != 0){
                return ResponseEntity.ok(new Result(true,"Helper Three Subject save",helperThreeSubjects));
            }

            return ResponseEntity.ok(new Result(false,"save not helper Three Subject",null));
        }catch (Exception e){
            log.error("HelperThreeSubject error save");
            return new ResponseEntity(new Result(false,"error save",e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> editHelperSubjectThree(HelperSubjectThreePayload payload){

        try {
            HelperThreeSubject helperThreeSubject = helperThreeSubjectRepository.findById(payload.getId()).orElseThrow(() -> new ResourceNotFoundException("subject not found"));

            Subject subject=subjectRepository.findById(payload.getSubjectOneId()).orElseThrow(()->new ResourceNotFoundException("subject not found"));

                helperThreeSubject.setHelperSecondSubject(helperSecondSubjectRepository.findById(payload.getHelperSubjectSecondId()).orElseThrow((()->new ResourceNotFoundException("HelperSecond not found"))));
                helperThreeSubject.setSubject(subject);
                helperThreeSubject=(helperThreeSubjectRepository.save(helperThreeSubject));

            if (helperThreeSubject != null) {
                return ResponseEntity.ok(new Result(true, "edit subject", helperThreeSubject));
            }
            return new ResponseEntity(new Result(false, "edit error", null), HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            log.error("edit Subject error",e.getMessage());
            return new ResponseEntity(new Result(false,"error edit Subject",null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> deleteHelperSecondThree(Long uuid){

        try {
            helperThreeSubjectRepository.deleteById(uuid);
            return ResponseEntity.ok(new Result(true,"delete succesfull",null));
        }catch (Exception e) {
            log.error("delete Subject error");
            return new ResponseEntity(new Result(false, "error delte subject", uuid), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<HelperThreeSubject> getHelperThree(Long helperSecondId, Long firstId){

        try{
            List<HelperThreeSubject> helperThreeSubjects=helperThreeSubjectRepository.findAllByHelperThreeSubject(helperSecondId, firstId);
            if (helperThreeSubjects.size()>0 && helperThreeSubjects != null){
                return helperThreeSubjects;
            }
        }catch (Exception e){
            log.error("error HelperThreeSubject", e.getMessage());
        }
        return null;
    }

    @Override
    public ResponseEntity<?> getAllHelperThree(){

        return ResponseEntity.ok(helperThreeSubjectRepository.findAll());

    }

}
