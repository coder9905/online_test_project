package uz.zako.online_test.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.zako.online_test.entity.Answer;
import uz.zako.online_test.entity.Question;
import uz.zako.online_test.entity.User;
import uz.zako.online_test.exception.ResourceNotFoundException;
import uz.zako.online_test.model.Result;
import uz.zako.online_test.payload.AnswerPayload;
import uz.zako.online_test.payload.QuestionPayload;
import uz.zako.online_test.repository.AnswerRepository;
import uz.zako.online_test.repository.QuestionRepository;
import uz.zako.online_test.repository.SubjectRepository;
import uz.zako.online_test.repository.UserRepository;
import uz.zako.online_test.service.AnswerService;
import uz.zako.online_test.service.HistoryService;
import uz.zako.online_test.service.QuestionService;

import java.util.ArrayList;
import java.util.List;
import java.lang.Long;

@Service
@Slf4j
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final SubjectRepository subjectRepository;
    private final HistoryService historyService;
    private final UserRepository userRepository;
    private final AnswerRepository answerRepository;
    private final AnswerService answerService;

    @Override
    public ResponseEntity<?> saveQuestion(QuestionPayload payload) {

        try {

            Question question = new Question();

            question.setBody(payload.getBody());
            question.setDegree(payload.getDegree());
            question.setSubjectId(subjectRepository.findById(payload.getSubjectId()).orElseThrow(() -> new ResourceNotFoundException("subject not found")));

            question = questionRepository.save(question);

            List<AnswerPayload> answerPayloadList = payload.getAnswerPayloadList();

            for (int i = 0; i < answerPayloadList.size(); i++) {
                answerPayloadList.get(i).setQuestionId(question.getId());
                answerService.saveAnswer(answerPayloadList.get(i));
                System.out.println(answerPayloadList.get(i));
            }

            if (question != null) {
                return ResponseEntity.ok(new Result(true, "question save succesfull", question));
            }
            return new ResponseEntity(new Result(false, "save no question", null), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            log.error("Question save error", e.getMessage());
            return new ResponseEntity(new Result(false, "save no question", null), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> editQuestion(QuestionPayload payload) {
        try {
            Question question = questionRepository.findById(payload.getId()).orElseThrow(() -> new ResourceNotFoundException("Question not found"));
            question.setBody(payload.getBody());
            question.setDegree(payload.getDegree());

            question = questionRepository.save(question);
            if (question != null) {
                return ResponseEntity.ok(new Result(true, "question save succesfull", question));
            }
            return new ResponseEntity(new Result(false, "save no question", null), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            log.error("Question save error", e.getMessage());
            return new ResponseEntity(new Result(false, "save no question", null), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> deleteQuestion(Long uuid) {
        try {
            questionRepository.deleteById(uuid);
            return ResponseEntity.ok(new Result(true, "question delete succesfull", null));
        } catch (Exception e) {
            log.error("delete Questin error", e.getMessage());
            return new ResponseEntity(new Result(false, "save no question", null), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<QuestionPayload> getQuestionBlockFirst(Long userId, QuestionPayload payload) {

        try {

            List<Long> questions = new ArrayList<>();
            questions.add(payload.getSubjectFirstId());
            questions.add(payload.getSubjectSecondId());
            questions.add(payload.getSubjectThreeId());

            List<QuestionPayload> questionPayloadList = new ArrayList<>();

            for (int i = 0; i < questions.size(); i++) {

                List<Question> uuidList = questionRepository.findAllByQuestionId(questions.get(i));

                uuidList.forEach(uuid -> {

                    Question question = questionRepository.findById(uuid.getId()).orElseThrow(() -> new ResourceNotFoundException("question not found"));

                    QuestionPayload questionPayload = new QuestionPayload();
                    questionPayload.setBody(question.getBody());
                    questionPayload.setDegree(question.getDegree());
                    questionPayload.setSubjectId((question.getSubjectId().getId()));
                    questionPayload.setId(question.getId());

                    List<AnswerPayload> answerPayloadList = new ArrayList<>();

                    System.out.println(question.getId());

                    List<Answer> answer = answerRepository.findAllByQuestionAnswer(question.getId());

                    System.out.println(answer);

                    answer.forEach(answer1 -> {
                        AnswerPayload answerPayload = new AnswerPayload();
                        answerPayload.setOption(answer1.getOption());
                        answerPayload.setId(answer1.getId());
                        answerPayload.setIsRight(answer1.getIsRight());
                        answerPayloadList.add(answerPayload);
                    });
                    questionPayload.setAnswerPayloadList(answerPayloadList);
                    questionPayloadList.add(questionPayload);

                });

            }
            return questionPayloadList;
        } catch (Exception e) {
            log.error("error question List", e.getMessage());
            return null;
        }
    }


    @Override
    public ResponseEntity<?> getAllQuestion() {

        try {
            return ResponseEntity.ok(new Result(true, "All Questions", questionRepository.findAll()));
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity(new Result(false, "save no question", null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
