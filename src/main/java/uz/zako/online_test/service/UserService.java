package uz.zako.online_test.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import uz.zako.online_test.payload.UserPayload;

public interface UserService {

    ResponseEntity<?> saveUser(@RequestBody UserPayload payload);
}
