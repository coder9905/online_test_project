package uz.zako.online_test.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import uz.zako.online_test.entity.abstractentity.AbstractEntity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User extends AbstractEntity {

//    @Column(unique = true, nullable = false)
    private String username;

    private String fullName;

    @Column(unique = true, nullable = false)
    private String password;

    private Boolean isAdmin;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id"))
    private List<Role> roles;

//    @CreatedBy
//    @ManyToOne
//    private User createdBy;
//
//    @LastModifiedBy
//    @ManyToOne
//    private User updatedBy;

}
