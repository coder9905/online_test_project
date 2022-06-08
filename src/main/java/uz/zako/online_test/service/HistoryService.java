package uz.zako.online_test.service;

import org.springframework.http.ResponseEntity;
import uz.zako.online_test.entity.User;
import uz.zako.online_test.payload.AnswerPayload;
import uz.zako.online_test.payload.HistoryPayload;

import java.util.UUID;

public interface HistoryService {

    ResponseEntity<?> saveHistory(HistoryPayload payload);

    void saveHistoryAnswer(UUID questionId, AnswerPayload payload);

    User getByTokenUser();

    HistoryPayload getHistoryResult();

    ResponseEntity<?> getAllHistory();
}
