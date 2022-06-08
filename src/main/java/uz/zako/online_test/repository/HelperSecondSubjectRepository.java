package uz.zako.online_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.zako.online_test.entity.helper.HelperFirstSubject;
import uz.zako.online_test.entity.helper.HelperSecondSubject;
import uz.zako.online_test.payload.HelperSubjectSecondPayload;
import uz.zako.online_test.payload.SubjectPayload;

import java.util.List;
import java.util.UUID;

@Repository
public interface HelperSecondSubjectRepository extends JpaRepository<HelperSecondSubject, UUID> {


    List<HelperSecondSubject> findAllByHelperFirstSubjectId(UUID uuid);

}
