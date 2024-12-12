package com.videodekhlo.video_streaming.login;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class LoginServiceImpl implements LoginService{

    private Long nextId = 1L;

    LoginRepository userRepository;

    private LoginServiceImpl (LoginRepository userRepository){ this.userRepository = userRepository;}

    @Override
    public List<Login> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void createUserLogin(Login user) {
        user.setID(nextId++);
        userRepository.save(user);
    }

    @Override
    public String forgetPassword() {
        return "";
    }

    @Override
    public String resetPassword(String emailId) {
        List<Login> loginId = findAll();
        boolean result = false;
        for (Login login : loginId) {
            result = login.getLOGINID().equals(emailId);
            if (result) {
                System.out.println("email id matched successfully");
                return createOtp();
            }
        }
        return "Error code 400";
    }

    private String createOtp() {
        //Integer otp = Integer.parseInt(createNewOTP());
        LocalDateTime now = LocalDateTime.now();
        //OTP otpEntity = OTP.builder().email(email).oneTimePassword(otp).otpTimestamp(now).build();
        System.out.println(createNewOTP().concat(String.valueOf(now)));
        return createNewOTP().concat(String.valueOf(now));
    }
    private String createNewOTP() {
        Random random = new Random();
        return String.format("%06d", random.nextInt(100000,900000));
    }



}
