package uz.zako.online_test.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.zako.online_test.entity.History;

import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BlockPayload {

    private Long id;

    private Long firstBlock;

    private Long secondBlock;

    private Long threeBlock;

    private Long historyId;

    public BlockPayload(Long firstBlock, Long secondBlock, Long threeBlock, Long historyId) {
        this.firstBlock = firstBlock;
        this.secondBlock = secondBlock;
        this.threeBlock = threeBlock;
        this.historyId = historyId;
    }
}
