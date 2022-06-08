package uz.zako.online_test.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import uz.zako.online_test.entity.User;
import uz.zako.online_test.model.Result;
import uz.zako.online_test.payload.UserPayload;
import uz.zako.online_test.repository.UserRepository;
import uz.zako.online_test.security.JwtTokenProvider;
import uz.zako.online_test.security.SecurityUtils;
import uz.zako.online_test.service.UserService;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final SecurityUtils securityUtils;

    @PostMapping("/token")
    public ResponseEntity<?> getToken(@RequestBody UserPayload payload) {

        if (true) {
            User user = userRepository.findByUsername(payload.getUsername());
            System.out.println(user.toString());
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(payload.getUsername(), payload.getPassword()));
            String token = jwtTokenProvider.createToken(user.getUsername(), user.getRoles());
            System.out.println(token.toString());
            if (token == null) {
                return new ResponseEntity(new Result(false, "error", null), HttpStatus.BAD_REQUEST);
            }
            Map<String, Object> map = new HashMap();
            map.put("token", token);
            map.put("username", true);
            return ResponseEntity.ok(map);
        }
        return ResponseEntity.ok(new Result(false, "error", null));

    }

    @PostMapping("/save/user")
    public ResponseEntity<?> saveUser(@RequestBody UserPayload payload) {
        return userService.saveUser(payload);
    }


}
