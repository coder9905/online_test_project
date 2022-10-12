package uz.zako.online_test.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.zako.online_test.entity.Subject;
import uz.zako.online_test.entity.helper.HelperFirstSubject;
import uz.zako.online_test.exception.ResourceNotFoundException;
import uz.zako.online_test.model.Result;
import uz.zako.online_test.payload.HelperSubjectFirstPayload;
import uz.zako.online_test.payload.SubjectPayload;
import uz.zako.online_test.repository.HelperFirstSubjectRepository;
import uz.zako.online_test.repository.SubjectRepository;
import uz.zako.online_test.service.HelperFirstSubjectService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class HelperFirstSubjectImpl implements HelperFirstSubjectService {

    private final SubjectRepository subjectRepository;
    private final HelperFirstSubjectRepository helperFirstSubjectRepository;

    @Override
    public ResponseEntity<?> saveHelperFisrtSubject(HelperSubjectFirstPayload payload){

        try {
            List<HelperFirstSubject> subject = new ArrayList<>();

            List<Subject> subjectList = subjectRepository.findAllById(payload.getSubjectId());

            for (int i = 0; i < subjectList.size(); i++) {
                HelperFirstSubject helperFirstSubject=new HelperFirstSubject();
                helperFirstSubject.setSubject(subjectList.get(i));
                subject.add(helperFirstSubjectRepository.save(helperFirstSubject));
            }

            if (subject != null && subject.size() != 0) {
                return ResponseEntity.ok(new Result(true, "save succesfull", subject));
            }
            return ResponseEntity.ok(new Result(false,"save not helperfirstSubject",null));
        }catch (Exception e){
            log.error("HelperFirstSubject error save");
            return new ResponseEntity(new Result(false,"error save",e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> editHelperSubjectFirst(HelperSubjectFirstPayload payload){

        try {

            HelperFirstSubject subject=helperFirstSubjectRepository.findById(payload.getId()).orElseThrow(()->new ResourceNotFoundException("helperFirst not found"));

            subject.setSubject(subjectRepository.findById(payload.getSubjectOneId()).orElseThrow(()->new ResourceNotFoundException("subject not found helperfirst")));

            subject=helperFirstSubjectRepository.save(subject);


            if (subject != null) {
                return ResponseEntity.ok(new Result(true, "edit subject", subject));
            }
            return new ResponseEntity(new Result(false, "edit error", null), HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            log.error("edit Subject error",e.getMessage());
            return new ResponseEntity(new Result(false,"error edit Subject",null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> deleteHelperFirstSubject(Long uuid){

        try {
            helperFirstSubjectRepository.deleteById(uuid);
            return ResponseEntity.ok(new Result(true,"delete succesfull",null));
        }catch (Exception e) {
            log.error("delete Subject error");
            return new ResponseEntity(new Result(false, "error delte subject", uuid), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> getAllHelperFirst(){

        return ResponseEntity.ok(helperFirstSubjectRepository.findAll());

    }

}
