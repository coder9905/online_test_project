package uz.zako.online_test.service;

import org.springframework.http.ResponseEntity;
import uz.zako.online_test.entity.helper.HelperSecondSubject;
import uz.zako.online_test.payload.HelperSubjectSecondPayload;

import java.util.List;

public interface HelperSecondSubjectService {

    ResponseEntity<?> saveHelperSecondSubject(HelperSubjectSecondPayload payload);

    ResponseEntity<?> editHelperSubjectSecond(HelperSubjectSecondPayload payload);

    ResponseEntity<?> deleteHelperSecondSubject(Long uuid);

    List<HelperSecondSubject> getHelperSecond(Long helperFirstId);

    ResponseEntity<?>  getAllHelperSecond();

}
