package uz.zako.online_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.zako.online_test.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
