package uz.zako.online_test.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.zako.online_test.entity.Subject;
import uz.zako.online_test.entity.helper.HelperFirstSubject;
import uz.zako.online_test.entity.helper.HelperSecondSubject;
import uz.zako.online_test.entity.helper.HelperThreeSubject;
import uz.zako.online_test.payload.*;
import uz.zako.online_test.service.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/client")
public class ClientController {

    private final HistoryService historyService;
    private final HelperSecondSubjectService helperSecondSubjectService;
    private final HelperThreeSubjectService helperThreeSubjectService;
    private final HelperFirstSubjectService helperFirstSubjectService;

    @PostMapping("/save/history")
    public ResponseEntity<?> saveHistory(@RequestBody HistoryPayload payload){
        return historyService.saveHistory(payload);
    }

    @PostMapping("/save/answer/{id}")
    public void saveAnswer(@PathVariable("id") UUID id,@RequestBody AnswerPayload payload){
        System.out.println(payload);
        historyService.saveHistoryAnswer(id,payload);
    }

    @GetMapping("/result")
    public HistoryPayload getHistoryResult(){
        return historyService.getHistoryResult();
    }

    @GetMapping("/first")
    public ResponseEntity<?> getFirstSubject(){
        return helperFirstSubjectService.getAllHelperFirst();
    }

    @GetMapping("/second/{id}")
    public List<HelperSecondSubject> getSecond(@PathVariable("id") UUID id){
        return helperSecondSubjectService.getHelperSecond(id);
    }

    @GetMapping("/three/{id}")
    public List<HelperSubjectThreePayload> getThree(@PathVariable("id") UUID id){
        System.out.println(id);
        return helperThreeSubjectService.getHelperThree(id);
    }
}
