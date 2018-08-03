package com.lycoo.tweetengine.restdemo.auth.service;

import org.springframework.mail.SimpleMailMessage;


public interface EmailService {
    void sendEmail(SimpleMailMessage email);
}