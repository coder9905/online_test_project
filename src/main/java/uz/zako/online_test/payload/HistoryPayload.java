package uz.zako.online_test.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.zako.online_test.entity.User;
import uz.zako.online_test.entity.selectAnswer.SelectAnswerFirst;
import uz.zako.online_test.entity.selectAnswer.SelectAnswerSecond;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HistoryPayload {

    private Long resultat;

    private UUID answerId;

    private UUID helperFirstId;

    private UUID helperSecondId;

    private UUID helperThreeId;

    private Double firstBlockBall;

    private Double secondBlockBall;

    private Double threeBlockBall;

    public HistoryPayload(UUID helperFirstId, UUID helperSecondId, UUID helperThreeId) {
        this.helperFirstId = helperFirstId;
        this.helperSecondId = helperSecondId;
        this.helperThreeId = helperThreeId;
    }

    public HistoryPayload(Double firstBlockBall, Double secondBlockBall, Double threeBlockBall) {
        this.firstBlockBall = firstBlockBall;
        this.secondBlockBall = secondBlockBall;
        this.threeBlockBall = threeBlockBall;
    }
}
