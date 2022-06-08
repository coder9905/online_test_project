//package uz.zako.online_test.entity;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import lombok.NoArgsConstructor;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//import uz.zako.online_test.entity.abstractentity.AbstractEntity;
//
//import javax.persistence.*;
//import java.util.Date;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@EqualsAndHashCode
//@Data
//@Entity
//public class ConfirmCode extends AbstractEntity {
//
//    private String code;
//
//    @ManyToOne(cascade = CascadeType.MERGE)
//    private User user;
//
//}
