package uz.zako.online_test.service;

import org.springframework.http.ResponseEntity;
import uz.zako.online_test.entity.helper.HelperThreeSubject;
import uz.zako.online_test.payload.HelperSubjectThreePayload;

import java.util.List;

public interface HelperThreeSubjectService {


    ResponseEntity<?> saveHelperThreeSubject(HelperSubjectThreePayload payload);

    ResponseEntity<?> editHelperSubjectThree(HelperSubjectThreePayload payload);

    ResponseEntity<?> deleteHelperSecondThree(Long uuid);

    List<HelperThreeSubject> getHelperThree(Long helperSecondId, Long firstId);

    ResponseEntity<?> getAllHelperThree();
}
