package uz.zako.online_test.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.zako.online_test.entity.Question;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AnswerPayload {

    private Long id;

    private String option;

    private Boolean isRight;

    private Long questionId;

    public AnswerPayload(String option, Boolean isRight, Long questionId) {
        this.option = option;
        this.isRight = isRight;
        this.questionId = questionId;
    }

    public AnswerPayload(Long id, String option, Boolean isRight) {
        this.id = id;
        this.option=option;
        this.isRight = isRight;
    }

}
