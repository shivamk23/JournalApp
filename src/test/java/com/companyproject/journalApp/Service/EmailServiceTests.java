package com.companyproject.journalApp.Service;

import com.companyproject.journalApp.services.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootTest
public class EmailServiceTests {



    @Autowired
    private EmailService emailService;

    @Test
    void testSendMail(){
        emailService.sendMail( "shivamsk2315@gmail.com","testing java spring boot mail","hi aap kse ho");
    }



}
