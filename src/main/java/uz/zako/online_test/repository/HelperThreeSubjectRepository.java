package uz.zako.online_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.zako.online_test.entity.helper.HelperSecondSubject;
import uz.zako.online_test.entity.helper.HelperThreeSubject;
import uz.zako.online_test.payload.HelperSubjectThreePayload;

import java.util.List;
import java.util.UUID;

@Repository
public interface HelperThreeSubjectRepository extends JpaRepository<HelperThreeSubject, Long> {

    @Query("select new uz.zako.online_test.payload.HelperSubjectThreePayload(ht.id, ht.subject) from HelperThreeSubject ht inner join HelperSecondSubject hs on ht.helperSecondSubject.id=hs.id inner join HelperFirstSubject hf on hs.helperFirstSubject.id=hf.id where ht.helperSecondSubject.id=:id")
    List<HelperSubjectThreePayload> findAllByHelperThreeSubject(@Param("id") Long id);

}
