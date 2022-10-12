package uz.zako.online_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.zako.online_test.entity.History;
import uz.zako.online_test.payload.HistoryPayload;


@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {

    @Query(nativeQuery = true, value = "select * from History h where h.user_id=:id ORDER BY h.created_at desc limit 1")
    History findByUserId(@Param("id") Long uuid);

    @Query(" select new uz.zako.online_test.payload.HistoryPayload(h.firstBlockBall, h.secondBlockBall, h.threeBlockBall) from History h where h.id=:id")
    HistoryPayload getHistoryId(@Param("id") Long id);

}
