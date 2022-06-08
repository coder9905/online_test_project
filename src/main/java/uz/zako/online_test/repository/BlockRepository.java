package uz.zako.online_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.zako.online_test.entity.Block;
import uz.zako.online_test.entity.History;

import java.util.UUID;

@Repository
public interface BlockRepository extends JpaRepository<Block, UUID> {

    @Query(nativeQuery = true, value = "select * from Block b where b.history_id_id=:id")
    Block findByHistoryId(@Param("id") UUID uuid);

}
