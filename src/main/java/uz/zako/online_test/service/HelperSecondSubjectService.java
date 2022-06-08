package uz.zako.online_test.service;

import org.springframework.http.ResponseEntity;
import uz.zako.online_test.entity.helper.HelperSecondSubject;
import uz.zako.online_test.payload.HelperSubjectSecondPayload;

import java.util.List;
import java.util.UUID;

public interface HelperSecondSubjectService {

    ResponseEntity<?> saveHelperSecondSubject(HelperSubjectSecondPayload payload);

    ResponseEntity<?> editHelperSubjectSecond(HelperSubjectSecondPayload payload);

    ResponseEntity<?> deleteHelperSecondSubject(UUID uuid);

    List<HelperSecondSubject> getHelperSecond(UUID helperFirstId);

    ResponseEntity<?>  getAllHelperSecond();

}
