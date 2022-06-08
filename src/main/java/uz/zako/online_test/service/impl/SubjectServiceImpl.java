package uz.zako.online_test.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.zako.online_test.entity.Subject;
import uz.zako.online_test.exception.ResourceNotFoundException;
import uz.zako.online_test.model.Result;
import uz.zako.online_test.payload.SubjectPayload;
import uz.zako.online_test.repository.SubjectRepository;
import uz.zako.online_test.service.SubjectService;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    @Override
    public Subject saveSubject(SubjectPayload subjectPayload){

        Subject subject=new Subject();
        subject.setName(subjectPayload.getName());
        Subject subject1=subjectRepository.save(subject);

        if (subject1!=null){
            return subject1;
        }
        return null;

    }

    @Override
    public ResponseEntity<?> editSubject(SubjectPayload payload){

        try {
            Subject subject = subjectRepository.findById(payload.getId()).orElseThrow(() -> new ResourceNotFoundException("subject not found"));
            subject.setName(payload.getName());

            subject = subjectRepository.save(subject);

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
    public ResponseEntity<?> deleteSubject(UUID uuid){
        try {
            subjectRepository.deleteById(uuid);
            return ResponseEntity.ok(new Result(true,"delete succesfull",null));
        }catch (Exception e) {
            log.error("delete Subject error");
            return new ResponseEntity(new Result(false, "error delte subject", uuid), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<Subject> getAllSubject(){

        List<Subject> subjectList=subjectRepository.findAll();

        if (subjectList != null) {
            return subjectList;
        }
        return null;

    }

}
