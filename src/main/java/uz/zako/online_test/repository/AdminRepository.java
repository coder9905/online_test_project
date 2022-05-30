package uz.zako.online_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.zako.online_test.entity.Admin;
import uz.zako.online_test.entity.Role;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
