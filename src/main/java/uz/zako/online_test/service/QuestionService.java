package uz.zako.online_test.service;

import org.springframework.http.ResponseEntity;
import uz.zako.online_test.entity.Question;
import uz.zako.online_test.payload.HelperSubjectFirstPayload;
import uz.zako.online_test.payload.QuestionPayload;

import java.util.List;

public interface QuestionService {

    ResponseEntity<?> saveQuestion(QuestionPayload payload);

    ResponseEntity<?> editQuestion(QuestionPayload payload);

    ResponseEntity<?> deleteQuestion(Long uuid);

    List<QuestionPayload> getQuestionBlockFirst(Long userId, QuestionPayload payload);

    ResponseEntity<?> getAllQuestion();
}
