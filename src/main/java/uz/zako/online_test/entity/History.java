package uz.zako.online_test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.zako.online_test.entity.abstractentity.AbstractEntity;
import uz.zako.online_test.entity.selectAnswer.SelectAnswerFirst;
import uz.zako.online_test.entity.selectAnswer.SelectAnswerSecond;
import uz.zako.online_test.entity.selectAnswer.SelectAnswerThree;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
@Entity

public class History extends AbstractEntity {

    private Date startDate;

    private Date expirationTime;

    private Double firstBlockBall;

    private Double secondBlockBall;

    private Double threeBlockBall;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

}
