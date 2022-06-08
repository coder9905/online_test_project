package uz.zako.online_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.zako.online_test.entity.Answer;
import uz.zako.online_test.entity.Question;

import java.util.List;
import java.util.UUID;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, UUID> {

    @Query(nativeQuery = true, value = "select * from Answer a where a.question_id_id=:id order by random() limit 4")
    List<Answer> findAllByQuestionAnswer(@Param("id") UUID uuid);



}
