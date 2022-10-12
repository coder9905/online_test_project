package uz.zako.online_test.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.zako.online_test.entity.Question;
import uz.zako.online_test.entity.Subject;
import uz.zako.online_test.entity.User;
import uz.zako.online_test.entity.helper.HelperFirstSubject;
import uz.zako.online_test.model.Result;
import uz.zako.online_test.payload.*;
import uz.zako.online_test.repository.UserRepository;
import uz.zako.online_test.service.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/")
public class AdminController {

    private final SubjectService subjectService;
    private final HelperFirstSubjectService helperFirstSubjectService;
    private final HelperSecondSubjectService helperSecondSubjectService;
    private final HelperThreeSubjectService helperThreeSubjectService;
    private final QuestionService questionService;
    private final AnswerService answerService;
    private final UserRepository userRepository;

    @GetMapping("/all/users")
    public ResponseEntity<?> getAllUsers(){
        try {
            List<User> users=userRepository.findAll();
            if (users != null){
                return ResponseEntity.ok(users);
            }
            return new ResponseEntity(new Result(false,"error get All Users",null), HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity(new Result(false,"error get All Users",null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public List<Subject> getAllSubject(){
        return subjectService.getAllSubject();
    }

    @PostMapping("/subject")
    public Subject saveSubject(@RequestBody SubjectPayload subjectPayload){
        return subjectService.saveSubject(subjectPayload);
    }

    @PutMapping("/editSubject")
    public ResponseEntity<?> editSubject(@RequestBody SubjectPayload payload){
        return subjectService.editSubject(payload);
    }

    @DeleteMapping("/deleteSubject/{id}")
    public ResponseEntity<?> deleteSubject(@PathVariable("id") Long uuid){
        return subjectService.deleteSubject(uuid);
    }

    @GetMapping("/all/helperFirst")
    public ResponseEntity<?> getAllHelperFirst(){
        return helperFirstSubjectService.getAllHelperFirst();
    }

    @PostMapping("/helperFirst")
    public ResponseEntity<?> saveHelperFirst(@RequestBody HelperSubjectFirstPayload payload){
        System.out.println(payload);
        return helperFirstSubjectService.saveHelperFisrtSubject(payload);

    }

    @PutMapping("/edithelperFirst")
    public ResponseEntity<?> editHelperFirst(@RequestBody HelperSubjectFirstPayload payload){
        return helperFirstSubjectService.editHelperSubjectFirst(payload);
    }

    @DeleteMapping("/deletehelperFirst/{id}")
    public ResponseEntity<?> deleteHelperFirst(@PathVariable("id") Long uuid){
        return helperFirstSubjectService.deleteHelperFirstSubject(uuid);
    }


    @GetMapping("/all/helperSecond")
    public ResponseEntity<?> getAllHelperSecond(){
        return helperSecondSubjectService.getAllHelperSecond();
    }

    @PostMapping("/helperSecond")
    public ResponseEntity<?> saveHelperSecond(@RequestBody HelperSubjectSecondPayload payload){
        return helperSecondSubjectService.saveHelperSecondSubject(payload);
    }

    @PutMapping("/edithelperSecond")
    public ResponseEntity<?> editSecond(@RequestBody HelperSubjectSecondPayload payload){
        System.out.println(payload);
        return helperSecondSubjectService.editHelperSubjectSecond(payload);
    }

    @DeleteMapping("/deletehelperSecond/{id}")
    public ResponseEntity<?> deleteHelperSecond(@PathVariable("id") Long uuid){
        return helperSecondSubjectService.deleteHelperSecondSubject(uuid);
    }

    @GetMapping("/all/helperThree")
    public ResponseEntity<?> getAllHelperThree(){
        return helperThreeSubjectService.getAllHelperThree();
    }

    @PostMapping("/helperThree")
    public ResponseEntity<?> saveHelperThree(@RequestBody HelperSubjectThreePayload payload){
        return helperThreeSubjectService.saveHelperThreeSubject(payload);
    }
    @PutMapping("/edithelperThree")
    public ResponseEntity<?> editHelperThree(@RequestBody HelperSubjectThreePayload payload){
        System.out.println(payload);
        return helperThreeSubjectService.editHelperSubjectThree(payload);
    }

    @DeleteMapping("/deletehelperThree/{id}")
    public ResponseEntity<?> deleteHelperThree(@PathVariable("id") Long uuid){
        return helperThreeSubjectService.deleteHelperSecondThree(uuid);
    }

    @GetMapping("/all/question")
    public ResponseEntity<?> getAllQuestion(){
        return questionService.getAllQuestion();
    }

    @PostMapping("/save/question")
    public ResponseEntity<?> saveQuestion(@RequestBody QuestionPayload payload){
        return questionService.saveQuestion(payload);
    }

    @PutMapping("/edit/question")
    public ResponseEntity<?> editQuestion(@RequestBody QuestionPayload payload){
        return questionService.editQuestion(payload);
    }

    @DeleteMapping("/delete/question/{id}")
    public ResponseEntity<?> deleteQuestion(@PathVariable("id") Long uuid){
        return questionService.deleteQuestion(uuid);
    }

    @GetMapping("/all/answer")
    public ResponseEntity<?> getAllAnswer(){
        return answerService.getAllAnswer();
    }

    @PostMapping("/save/answer")
    public ResponseEntity<?> saveAnswer(@RequestBody AnswerPayload payload){
        System.out.println(payload);
        return answerService.saveAnswer(payload);
    }

    @PutMapping("/edit/answer")
    public ResponseEntity<?> editAnswer(AnswerPayload payload){
        return answerService.editAnswer(payload);
    }

//    @GetMapping("/block/question/{id}")
//    public List<QuestionPayload> getQuestionBlock(@PathVariable("id") Long id){
//        return questionService.getQuestionBlockFirst(id);
//    }

    @GetMapping("/chiqarish/{id}")
    public List<QuestionPayload> getQuestion(@PathVariable("id") Long id){
        return questionService.getQuestionBlockFirst(id);
    }

}
