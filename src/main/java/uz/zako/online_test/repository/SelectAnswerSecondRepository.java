package uz.zako.online_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.zako.online_test.entity.selectAnswer.SelectAnswerFirst;
import uz.zako.online_test.entity.selectAnswer.SelectAnswerSecond;

import java.util.UUID;

@Repository
public interface SelectAnswerSecondRepository extends JpaRepository<SelectAnswerSecond, Long> {
//    @Query(nativeQuery = true, value = "select * from SelectAnswerSecond s where s.history_id=:id")
    SelectAnswerSecond findByHistoryId(Long id);
}
