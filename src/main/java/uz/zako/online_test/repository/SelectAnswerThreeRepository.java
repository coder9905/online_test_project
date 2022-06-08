package uz.zako.online_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.zako.online_test.entity.selectAnswer.SelectAnswerFirst;
import uz.zako.online_test.entity.selectAnswer.SelectAnswerSecond;
import uz.zako.online_test.entity.selectAnswer.SelectAnswerThree;

import java.util.UUID;

@Repository
public interface SelectAnswerThreeRepository extends JpaRepository<SelectAnswerThree, UUID> {
//    @Query(nativeQuery = true, value = "select * from SelectAnswerThree s where s.history_id=:id")
    SelectAnswerThree findByHistoryId(UUID id);
}
