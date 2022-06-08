package uz.zako.online_test.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.zako.online_test.entity.Question;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AnswerPayload {

    private UUID id;

    private String option;

    private Boolean isRight;

    private UUID questionId;

    public AnswerPayload(String option, Boolean isRight, UUID questionId) {
        this.option = option;
        this.isRight = isRight;
        this.questionId = questionId;
    }

    public AnswerPayload(UUID id, String option, Boolean isRight) {
        this.id = id;
        this.option=option;
        this.isRight = isRight;
    }

}
