package com.companyproject.journalApp.repository;

import com.companyproject.journalApp.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserRepositoryImplTests {

    @Autowired
    private UserRespositoryImpl userRespository;

    @Test
    public void testGetUserForSA() {
        List<User> users = userRespository.getUserForSA();
        System.out.println("Fetched users: " + users);
        for (User user : users) {
            System.out.println("User email: " + user.getEmail());
        }
    }


}
