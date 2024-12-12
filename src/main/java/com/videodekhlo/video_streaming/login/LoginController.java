package com.videodekhlo.video_streaming.login;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {

    private LoginService loginService;

    public LoginController (LoginService loginService) {this.loginService = loginService;}



    public List<Login> findAllUsers(){
        return loginService.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<String> createUserLogin(@RequestBody Login login){
        loginService.createUserLogin(login);
        return new ResponseEntity<>("User Created Successfully", HttpStatus.OK);
    }

    @PostMapping("/reset")
    public ResponseEntity<String> resetPassword(@RequestBody String emailId){
        loginService.resetPassword(emailId);
        return new ResponseEntity<>("OTP sent Successfully", HttpStatus.OK);
    }

}
