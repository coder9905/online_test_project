package uz.zako.online_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.zako.online_test.entity.Question;
import uz.zako.online_test.payload.QuestionPayload;

import java.util.List;
import java.util.UUID;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query(nativeQuery = true, value = "select * from Question q WHERE q.subject_id_id=:id ORDER BY random() limit 3")
    List<Question> findAllByQuestionId(@Param("id") Long id);


}
