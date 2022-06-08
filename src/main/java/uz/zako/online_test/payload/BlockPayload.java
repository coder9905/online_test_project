package uz.zako.online_test.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.zako.online_test.entity.History;

import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BlockPayload {

    private UUID id;

    private UUID firstBlock;

    private UUID secondBlock;

    private UUID threeBlock;

    private UUID historyId;

    public BlockPayload(UUID firstBlock, UUID secondBlock, UUID threeBlock, UUID historyId) {
        this.firstBlock = firstBlock;
        this.secondBlock = secondBlock;
        this.threeBlock = threeBlock;
        this.historyId = historyId;
    }
}
