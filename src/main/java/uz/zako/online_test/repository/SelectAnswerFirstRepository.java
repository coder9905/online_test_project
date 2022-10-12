package uz.zako.online_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.zako.online_test.entity.Answer;
import uz.zako.online_test.entity.helper.HelperThreeSubject;
import uz.zako.online_test.entity.selectAnswer.SelectAnswerFirst;

import java.util.List;
import java.util.UUID;

@Repository
public interface SelectAnswerFirstRepository extends JpaRepository<SelectAnswerFirst, Long> {

    SelectAnswerFirst findByHistoryId(Long id);

//    @Query(nativeQuery = true, value = "update SelectAnswerFirst s set s.answer_list_id=:list where s.history_id=:id")
//    void update(@Param("list") List<Answer> answerList,@Param("id") UUID id);

}
