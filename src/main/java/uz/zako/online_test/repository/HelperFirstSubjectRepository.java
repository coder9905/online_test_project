package uz.zako.online_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.zako.online_test.entity.Subject;
import uz.zako.online_test.entity.helper.HelperFirstSubject;

import java.util.List;
import java.util.UUID;

@Repository
public interface HelperFirstSubjectRepository extends JpaRepository<HelperFirstSubject, UUID> {



}
