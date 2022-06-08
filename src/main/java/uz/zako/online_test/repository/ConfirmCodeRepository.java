//package uz.zako.online_test.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//import uz.zako.online_test.entity.ConfirmCode;
//import uz.zako.online_test.entity.helper.HelperFirstSubject;
//
//import java.util.UUID;
//
//@Repository
//public interface ConfirmCodeRepository extends JpaRepository<ConfirmCode, UUID> {
//
//    @Query(nativeQuery = true,value = "select * from public.confirm_code cc where cc.user_id=:id order by cc.created_at desc limit 1")
//    ConfirmCode findByUser(@Param("id") UUID uuid);
//
//}
