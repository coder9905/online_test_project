package uz.zako.online_test.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuestionPayload {

    private UUID id;

    private String body;

    private Long degree;

    private UUID subjectId;

    public QuestionPayload(String body, Long degree, UUID subjectId) {
        this.body = body;
        this.degree = degree;
        this.subjectId = subjectId;
    }

    List<AnswerPayload> answerPayloadList=new ArrayList<>();

    public QuestionPayload(UUID id, String body, Long degree) {
        this.id = id;
        this.body = body;
        this.degree = degree;
    }
}
