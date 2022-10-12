package uz.zako.online_test.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuestionPayload {

    private Long id;

    private String body;

    private Long degree;

    private Long subjectId;

    public QuestionPayload(String body, Long degree, Long subjectId) {
        this.body = body;
        this.degree = degree;
        this.subjectId = subjectId;
    }

    List<AnswerPayload> answerPayloadList=new ArrayList<>();

    public QuestionPayload(Long id, String body, Long degree) {
        this.id = id;
        this.body = body;
        this.degree = degree;
    }
}
