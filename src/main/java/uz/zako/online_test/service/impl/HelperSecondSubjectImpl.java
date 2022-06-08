package uz.zako.online_test.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.zako.online_test.entity.Subject;
import uz.zako.online_test.entity.helper.HelperSecondSubject;
import uz.zako.online_test.exception.ResourceNotFoundException;
import uz.zako.online_test.model.Result;
import uz.zako.online_test.payload.HelperSubjectSecondPayload;
import uz.zako.online_test.repository.HelperFirstSubjectRepository;
import uz.zako.online_test.repository.HelperSecondSubjectRepository;
import uz.zako.online_test.repository.SubjectRepository;
import uz.zako.online_test.service.HelperSecondSubjectService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class HelperSecondSubjectImpl implements HelperSecondSubjectService {

    private final SubjectRepository subjectRepository;
    private final HelperFirstSubjectRepository helperFirstSubjectRepository;
    private final HelperSecondSubjectRepository helperSecondSubjectRepository;

    @Override
    public ResponseEntity<?> saveHelperSecondSubject(HelperSubjectSecondPayload payload){

        try {
            List<HelperSecondSubject> helperSecondSubjects=new ArrayList<>();

            List<Subject> subjectList=subjectRepository.findAllById(payload.getSubjectId());
            for (int i = 0; i < subjectList.size(); i++) {

                HelperSecondSubject helperSecondSubject=new HelperSecondSubject();
                helperSecondSubject.setHelperFirstSubject(helperFirstSubjectRepository.findById(payload.getHelperSubjectFirstId()).get());
                helperSecondSubject.setSubject(subjectList.get(i));
                helperSecondSubjects.add(helperSecondSubjectRepository.save(helperSecondSubject));

            }

            if (helperSecondSubjects.size() != 0){
                return ResponseEntity.ok(new Result(true,"Helper Second Subject save",helperSecondSubjects));
            }

            return ResponseEntity.ok(new Result(false,"save not helper Second Subject",null));
        }catch (Exception e){
            log.error("HelperSecondSubject error save");
            return new ResponseEntity(new Result(false,"error save",e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> editHelperSubjectSecond(HelperSubjectSecondPayload payload){

        try {

            Subject subject=subjectRepository.findById(payload.getSubjectOneId()).orElseThrow(()->new ResourceNotFoundException("subject not found"));

            HelperSecondSubject helperSecondSubject = helperSecondSubjectRepository.findById(payload.getId()).orElseThrow(() -> new ResourceNotFoundException("subject not found"));
            helperSecondSubject.setHelperFirstSubject(helperFirstSubjectRepository.findById(payload.getHelperSubjectFirstId()).get());
            helperSecondSubject.setSubject(subject);
            helperSecondSubject=helperSecondSubjectRepository.save(helperSecondSubject);

            if (helperSecondSubject != null) {
                return ResponseEntity.ok(new Result(true, "edit subject", helperSecondSubject));
            }
            return new ResponseEntity(new Result(false, "edit error", null), HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            log.error("edit Subject error",e.getMessage());
            return new ResponseEntity(new Result(false,"error edit Subject",null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> deleteHelperSecondSubject(UUID uuid){

        try {
            helperSecondSubjectRepository.deleteById(uuid);
            return ResponseEntity.ok(new Result(true,"delete succesfull",null));
        }catch (Exception e) {
            log.error("delete Subject error");
            return new ResponseEntity(new Result(false, "error delte subject", uuid), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<HelperSecondSubject> getHelperSecond(UUID helperFirstId){

        List<HelperSecondSubject> helperSecondSubjects=helperSecondSubjectRepository.findAllByHelperFirstSubjectId(helperFirstId);

        try {
            if (helperSecondSubjects.size()>0 && helperSecondSubjects != null){
                return helperSecondSubjects;
            }
        }catch (Exception e){
            log.error("error getHelperSecondSubjects");
        }
        return null;
    }

    @Override
    public ResponseEntity<?> getAllHelperSecond(){

        return ResponseEntity.ok(helperSecondSubjectRepository.findAll());

    }

}
