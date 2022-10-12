package uz.zako.online_test.service;

import org.springframework.http.ResponseEntity;
import uz.zako.online_test.entity.helper.HelperFirstSubject;
import uz.zako.online_test.payload.HelperSubjectFirstPayload;

import java.util.List;
import java.util.UUID;

public interface HelperFirstSubjectService {
    ResponseEntity<?> saveHelperFisrtSubject(HelperSubjectFirstPayload payload);

    ResponseEntity<?> editHelperSubjectFirst(HelperSubjectFirstPayload payload);

    ResponseEntity<?> deleteHelperFirstSubject(Long uuid);

    ResponseEntity<?> getAllHelperFirst();
}
