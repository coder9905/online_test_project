package uz.zako.online_test.service;

import org.springframework.http.ResponseEntity;
import uz.zako.online_test.entity.Subject;
import uz.zako.online_test.payload.SubjectPayload;

import java.util.List;

public interface SubjectService {
    Subject saveSubject(SubjectPayload subjectPayload);

    ResponseEntity<?> editSubject(SubjectPayload payload);

    ResponseEntity<?> deleteSubject(Long uuid);

    List<Subject> getAllSubject();
}
