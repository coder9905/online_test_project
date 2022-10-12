package uz.zako.online_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.zako.online_test.entity.Subject;

import java.util.UUID;
@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {


}
