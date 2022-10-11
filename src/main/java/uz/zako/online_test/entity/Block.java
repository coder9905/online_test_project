package uz.zako.online_test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.zako.online_test.entity.abstractentity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Data

public class Block extends AbstractEntity {

    private UUID firstBlock;

    private UUID secondBlock;

    private UUID threeBlock;

    @OneToOne(fetch = FetchType.LAZY)
    private History historyId;

}
