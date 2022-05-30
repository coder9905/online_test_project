package uz.zako.online_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.zako.online_test.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
