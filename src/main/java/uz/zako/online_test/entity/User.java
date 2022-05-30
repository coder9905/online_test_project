package uz.zako.online_test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "users")
public class User extends AbstractEntity{

//    @Column(unique = true, nullable = false)
    private String username;

    private String fullName;

//    @Column(unique = true, nullable = false)
    private String password;

//    @Column(columnDefinition = "false")
    private Boolean isAdmin;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id"))
    private List<Role> roles;

}
