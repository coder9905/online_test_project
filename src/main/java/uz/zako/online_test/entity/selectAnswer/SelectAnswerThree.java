package uz.zako.online_test.entity.selectAnswer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.zako.online_test.entity.Answer;
import uz.zako.online_test.entity.History;
import uz.zako.online_test.entity.Question;
import uz.zako.online_test.entity.abstractentity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class SelectAnswerThree extends AbstractEntity {

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Answer> answer;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Question> questions;

    @OneToOne(fetch = FetchType.LAZY)
    private History history;

}
