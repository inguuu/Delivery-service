package com.example.deliver.api;

import com.example.deliver.dto.User;
import com.example.deliver.model.DefaultRes;
import com.example.deliver.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/board")
    public String board() {
        return "1";
    }

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody User user) {
        try {
            return new ResponseEntity<>(userService.signup(user), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            DefaultRes<Object> ISR = new DefaultRes<>(HttpStatus.INTERNAL_SERVER_ERROR,"서버 내부 오류" );
            return new ResponseEntity<>(ISR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
