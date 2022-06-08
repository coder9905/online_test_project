package uz.zako.online_test.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.zako.online_test.entity.Answer;
import uz.zako.online_test.entity.Question;
import uz.zako.online_test.exception.ResourceNotFoundException;
import uz.zako.online_test.model.Result;
import uz.zako.online_test.payload.AnswerPayload;
import uz.zako.online_test.payload.QuestionPayload;
import uz.zako.online_test.repository.AnswerRepository;
import uz.zako.online_test.repository.QuestionRepository;
import uz.zako.online_test.repository.SubjectRepository;
import uz.zako.online_test.service.AnswerService;
import uz.zako.online_test.service.QuestionService;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;
    private final SubjectRepository subjectRepository;
    private final QuestionRepository questionRepository;

    @Override
    public ResponseEntity<?> saveAnswer(AnswerPayload payload){
        try {
            Answer answer = new Answer();

            answer.setOption(payload.getOption());
            answer.setIsRight(payload.getIsRight());

            answer.setQuestionId(questionRepository.findById(payload.getQuestionId()).orElseThrow(() -> new ResourceNotFoundException("question not found")));

            answer = answerRepository.save(answer);

            if (answer != null) {
                return ResponseEntity.ok(new Result(true, "save answer succesfull", answer));
            }
            return new ResponseEntity(new Result(false, "save error answer", null), HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            log.error("save error answer",e.getMessage());
            return new ResponseEntity(new Result(false, "save error answer", null), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> editAnswer(AnswerPayload payload){
        try {

            Answer answer=answerRepository.findById(payload.getId()).orElseThrow(()->new ResourceNotFoundException("Answer not found"));

            answer.setOption(payload.getOption());
            answer.setIsRight(payload.getIsRight());
            answer=answerRepository.save(answer);

            if (answer != null) {
                return ResponseEntity.ok(new Result(true, "save answer succesfull", answer));
            }
            return new ResponseEntity(new Result(false, "save error answer", null), HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            log.error("save error answer",e.getMessage());
            return new ResponseEntity(new Result(false, "save error answer", null), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> getAllAnswer(){
        try{
            List<Answer> answerList=answerRepository.findAll();
            return ResponseEntity.ok(new Result(true,"all Answer",answerList));
        }catch (Exception e){
            log.error("save error answer",e.getMessage());
            return new ResponseEntity(new Result(false, "save error answer", null), HttpStatus.BAD_REQUEST);
        }
    }

}
