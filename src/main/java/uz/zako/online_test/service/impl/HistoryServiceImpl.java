package uz.zako.online_test.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.zako.online_test.entity.*;
import uz.zako.online_test.entity.selectAnswer.SelectAnswerFirst;
import uz.zako.online_test.entity.selectAnswer.SelectAnswerSecond;
import uz.zako.online_test.entity.selectAnswer.SelectAnswerThree;
import uz.zako.online_test.exception.ResourceNotFoundException;
import uz.zako.online_test.model.Result;
import uz.zako.online_test.payload.AnswerPayload;
import uz.zako.online_test.payload.HistoryPayload;
import uz.zako.online_test.repository.*;
import uz.zako.online_test.security.SecurityUtils;
import uz.zako.online_test.service.HistoryService;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class HistoryServiceImpl implements HistoryService {

    private final SecurityUtils securityUtils;
    private final HistoryRepository historyRepository;
    private final BlockRepository blockRepository;
    private final UserRepository userRepository;
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final SelectAnswerFirstRepository selectAnswerFirstRepository;
    private final SelectAnswerSecondRepository selectAnswerSecondRepository;
    private final SelectAnswerThreeRepository selectAnswerThreeRepository;

    @Override
    public ResponseEntity<?> saveHistory(HistoryPayload payload) {

        try {

            System.out.println(payload + "=payload");
            History history = new History();

            Date date = new Date();

            history.setStartDate(date);
            date.setHours(3);
            history.setExpirationTime(date);
            history.setFirstBlockBall(0d);
            history.setSecondBlockBall(0d);
            history.setThreeBlockBall(0d);

            User user = getByTokenUser();
            user = userRepository.findByUsername(user.getUsername());

            history.setUser(userRepository.findById(user.getId()).orElseThrow(() -> new ResourceNotFoundException("user not found historyServiecImpl")));

            history = historyRepository.save(history);

            Block block = new Block();

            block.setFirstBlock(payload.getHelperFirstId());
            block.setSecondBlock(payload.getHelperSecondId());
            block.setThreeBlock(payload.getHelperThreeId());

            SelectAnswerFirst selectAnswerFirst = new SelectAnswerFirst();
            selectAnswerFirst.setHistory(historyRepository.findById(history.getId()).orElseThrow(() -> new ResourceNotFoundException("history not found")));
            selectAnswerFirstRepository.save(selectAnswerFirst);

            SelectAnswerSecond selectAnswerSecond = new SelectAnswerSecond();
            selectAnswerSecond.setHistory(historyRepository.findById(history.getId()).orElseThrow(() -> new ResourceNotFoundException("history not found")));
            selectAnswerSecondRepository.save(selectAnswerSecond);

            SelectAnswerThree selectAnswerThree = new SelectAnswerThree();
            selectAnswerThree.setHistory(historyRepository.findById(history.getId()).orElseThrow(() -> new ResourceNotFoundException("history not found")));
            selectAnswerThreeRepository.save(selectAnswerThree);


            block.setHistoryId(historyRepository.findById(history.getId()).orElseThrow(() -> new ResourceNotFoundException("history not found historyServiceImpl")));

            block = blockRepository.save(block);

            if (history != null && block != null) {
                return ResponseEntity.ok(new Result(true, "save history succesfull", history));
            }
            return new ResponseEntity(new Result(false, "error save history", null), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            log.error("save history error");
            return new ResponseEntity(new Result(false, "error save history", null), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public void saveHistoryAnswer(Long questionId, AnswerPayload payload) {

        int count = 0;

        User user = userRepository.findByUsername(getByTokenUser().getUsername());
        Question question = questionRepository.findById(questionId).orElseThrow(() -> new ResourceNotFoundException("question not found"));
        History history = historyRepository.findByUserId(user.getId());
        Answer answer = answerRepository.findById(payload.getId()).orElseThrow(() -> new ResourceNotFoundException("answer not found"));

        System.out.println(history);

        Block block = blockRepository.findByHistoryId(history.getId());

        System.out.println(question.getSubjectId() + "==" + block.getSecondBlock());

        if (question.getSubjectId().getId().equals(block.getFirstBlock())) {

            SelectAnswerFirst selectAnswerFirst = selectAnswerFirstRepository.findByHistoryId(history.getId());
            List<Answer> answerList = selectAnswerFirst.getAnswer();
            List<Question> questionList = selectAnswerFirst.getQuestions();

            for (int i = 0; i < questionList.size(); i++) {
                if (questionList.get(i).getId().equals(questionId)) {
                    if (!answerList.get(i).getIsRight()) {
                        if (answer.getIsRight()) {
                            answerList.remove(i);
                            answerList.add(i,answerRepository.findById(payload.getId()).orElseThrow(() -> new ResourceNotFoundException("answer not found")));
                            Double ball = history.getFirstBlockBall();
                            ball = (ball) + 3.1;
                            history.setFirstBlockBall((ball));
                            historyRepository.save(history);
                        }
                    }else {
                        if (!answer.getIsRight()) {
                            answerList.remove(i);
                            answerList.add(i,answerRepository.findById(payload.getId()).orElseThrow(() -> new ResourceNotFoundException("answer not found")));
                            Double ball = history.getFirstBlockBall();
                            ball = (ball) - 3.1;
                            history.setFirstBlockBall((ball));
                            historyRepository.save(history);
                        }
                    }
                    count++;
                }
            }

            System.out.println(selectAnswerFirst.getAnswer());

            if (count == 0) {
                if (answer.getIsRight()) {
                    Double ball = history.getFirstBlockBall();
                    ball=ball+3.1;
                    history.setFirstBlockBall((ball));
                    historyRepository.save(history);
                }
                answerList.add(answerRepository.findById(payload.getId()).orElseThrow(() -> new ResourceNotFoundException("answer not found")));
                questionList.add(questionRepository.findById(questionId).orElseThrow(() -> new ResourceNotFoundException("question not found")));
            }

            selectAnswerFirst.setAnswer(answerList);
            selectAnswerFirst.setQuestions(questionList);

            selectAnswerFirstRepository.save(selectAnswerFirst);

            count = 0;

        } else if ((question.getSubjectId().getId().equals(block.getSecondBlock()))) {

            SelectAnswerSecond selectAnswerSecond = selectAnswerSecondRepository.findByHistoryId(history.getId());

            System.out.println(selectAnswerSecond.getAnswer());

            List<Answer> answerList = selectAnswerSecond.getAnswer();
            List<Question> questionList = selectAnswerSecond.getQuestions();

            for (int i = 0; i < questionList.size(); i++) {
                if (questionList.get(i).getId().equals(questionId)) {
                    if (!answerList.get(i).getIsRight()) {
                        if (answer.getIsRight()) {
                            answerList.remove(i);
                            answerList.add(i,answerRepository.findById(payload.getId()).orElseThrow(() -> new ResourceNotFoundException("answer not found")));
                            Double ball = history.getSecondBlockBall();
                            ball = ball + 2.1;
                            history.setSecondBlockBall((ball));
                            historyRepository.save(history);
                        }
                    }else {
                        if (!answer.getIsRight()) {
                            answerList.remove(i);
                            answerList.add(i,answerRepository.findById(payload.getId()).orElseThrow(() -> new ResourceNotFoundException("answer not found")));
                            Double ball = history.getSecondBlockBall();
                            ball = ball - 2.1;
                            history.setSecondBlockBall((ball));
                            historyRepository.save(history);
                        }
                    }
                    count++;
                }
            }

            System.out.println(selectAnswerSecond.getAnswer());

            if (count == 0) {
                if (answer.getIsRight()) {
                    Double ball = history.getSecondBlockBall();
                    ball = ball + 2.1;
                    history.setSecondBlockBall((ball));
                    historyRepository.save(history);
                }
                answerList.add(answerRepository.findById(payload.getId()).orElseThrow(() -> new ResourceNotFoundException("answer not found")));
                questionList.add(questionRepository.findById(questionId).orElseThrow(() -> new ResourceNotFoundException("question not found")));
            }

            selectAnswerSecond.setAnswer(answerList);
            selectAnswerSecond.setQuestions(questionList);

            selectAnswerSecondRepository.save(selectAnswerSecond);
            count = 0;

        } else if ((question.getSubjectId().getId().equals(block.getThreeBlock()))) {

            SelectAnswerThree selectAnswerThree = selectAnswerThreeRepository.findByHistoryId(history.getId());
            System.out.println(selectAnswerThree.getAnswer());

            List<Answer> answerList = selectAnswerThree.getAnswer();
            List<Question> questionList = selectAnswerThree.getQuestions();

            for (int i = 0; i < questionList.size(); i++) {
                if (questionList.get(i).getId().equals(questionId)) {
                    if (!answerList.get(i).getIsRight()) {
                        if (answer.getIsRight()) {
                            answerList.remove(i);
                            answerList.add(i,answerRepository.findById(payload.getId()).orElseThrow(() -> new ResourceNotFoundException("answer not found")));
                            Double ball = history.getThreeBlockBall();
                            ball=ball+1.1;
                            history.setThreeBlockBall((ball));
                            historyRepository.save(history);
                        }
                    }else {
                        if (!answer.getIsRight()) {
                            answerList.remove(i);
                            answerList.add(i,answerRepository.findById(payload.getId()).orElseThrow(() -> new ResourceNotFoundException("answer not found")));
                            Double ball = history.getThreeBlockBall();
                            ball=ball-1.1;
                            history.setThreeBlockBall((ball));
                            historyRepository.save(history);
                        }
                    }
                    count++;
                }
            }
            System.out.println(selectAnswerThree.getAnswer());
            if (count == 0) {
                if (answer.getIsRight()) {
                    Double ball = history.getThreeBlockBall();
                    ball=ball+1.1;
                    history.setThreeBlockBall((ball));
                    historyRepository.save(history);
                }
                answerList.add(answerRepository.findById(payload.getId()).orElseThrow(() -> new ResourceNotFoundException("answer not found")));
                questionList.add(questionRepository.findById(questionId).orElseThrow(() -> new ResourceNotFoundException("question not found")));
            }

            selectAnswerThree.setAnswer(answerList);
            selectAnswerThree.setQuestions(questionList);

            selectAnswerThreeRepository.save(selectAnswerThree);

            System.out.println(history.getFirstBlockBall());
            count = 0;
        }
    }


    @Override
    public User getByTokenUser() {
        String username = securityUtils.getCurrentUser().orElseThrow(() -> new RuntimeException("error"));
        User user = new User();
        user.setUsername(username);
        return user;
    }

    @Override
    public HistoryPayload getHistoryResult() {
        try {
            User user = getByTokenUser();
            user = userRepository.findByUsername(user.getUsername());
            History history = historyRepository.findByUserId(user.getId());
            HistoryPayload historyPayload = historyRepository.getHistoryId(history.getId());
            if (historyPayload != null) {
                return historyPayload;
            }
        } catch (Exception e) {
            log.error("error history result", e.getMessage());
        }
        return null;
    }

    @Override
    public ResponseEntity<?> getAllHistory() {
        try {
            List<History> histories = historyRepository.findAll();
            return ResponseEntity.ok(new Result(true, "All History", histories));
        } catch (Exception e) {
            log.error("getAllHistoryr error", e.getMessage());
            return new ResponseEntity(new Result(false, "error All History", null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
