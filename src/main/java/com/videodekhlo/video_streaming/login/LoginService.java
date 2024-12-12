package com.videodekhlo.video_streaming.login;

import java.util.List;

public interface LoginService {

    List<Login> findAll();

    public void createUserLogin(Login user);

    public String forgetPassword(); // must return OTP

    public String resetPassword(String emailId);
}
