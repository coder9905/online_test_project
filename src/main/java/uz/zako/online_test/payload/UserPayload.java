package uz.zako.online_test.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserPayload {

    private UUID id;

    private String username;

    public UserPayload(String username) {
        this.username = username;
    }

    private String fullName;

    private String password;

    private Boolean isAdmin;

    public UserPayload(String username, String fullName, String password, Boolean isAdmin) {
        this.username = username;
        this.fullName = fullName;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public UserPayload(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
