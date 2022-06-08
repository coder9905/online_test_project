package uz.zako.online_test.service;

import org.springframework.http.ResponseEntity;
import uz.zako.online_test.payload.AnswerPayload;
import uz.zako.online_test.payload.QuestionPayload;

import java.util.UUID;

public interface AnswerService {
    ResponseEntity<?> saveAnswer(AnswerPayload payload);

    ResponseEntity<?> editAnswer(AnswerPayload payload);

    ResponseEntity<?> getAllAnswer();
}
