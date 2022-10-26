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

    private Long subjectFirstId;
    private Long subjectSecondId;
    private Long subjectThreeId;

    public QuestionPayload(Long subjectFirstId, Long subjectSecondId, Long subjectThreeId) {
        this.subjectFirstId = subjectFirstId;
        this.subjectSecondId = subjectSecondId;
        this.subjectThreeId = subjectThreeId;
    }

    private List<AnswerPayload> answerPayloadList;

    public QuestionPayload(String body, Long degree, Long subjectId) {
        this.body = body;
        this.degree = degree;
        this.subjectId = subjectId;
    }

    public QuestionPayload(String body, Long degree, Long subjectId, List<AnswerPayload> answerPayloadList) {
        this.body = body;
        this.degree = degree;
        this.subjectId = subjectId;
        this.answerPayloadList = answerPayloadList;
    }

    public QuestionPayload(Long id, String body, Long degree) {
        this.id = id;
        this.body = body;
        this.degree = degree;
    }
}
