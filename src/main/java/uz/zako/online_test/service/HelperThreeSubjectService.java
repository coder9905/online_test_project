package uz.zako.online_test.service;

import org.springframework.http.ResponseEntity;
import uz.zako.online_test.entity.helper.HelperThreeSubject;
import uz.zako.online_test.payload.HelperSubjectSecondPayload;
import uz.zako.online_test.payload.HelperSubjectThreePayload;

import java.util.List;
import java.util.UUID;

public interface HelperThreeSubjectService {


    ResponseEntity<?> saveHelperThreeSubject(HelperSubjectThreePayload payload);

    ResponseEntity<?> editHelperSubjectThree(HelperSubjectThreePayload payload);

    ResponseEntity<?> deleteHelperSecondThree(UUID uuid);

    List<HelperSubjectThreePayload> getHelperThree(UUID helperSecondId);

    ResponseEntity<?> getAllHelperThree();
}
