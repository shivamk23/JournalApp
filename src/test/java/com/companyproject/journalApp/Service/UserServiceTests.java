package com.companyproject.journalApp.Service;

import com.companyproject.journalApp.entity.User;
import com.companyproject.journalApp.repository.UserRepository;
import com.companyproject.journalApp.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;


    @ParameterizedTest
    @ArgumentsSource(UserArgumentsProvider.class)
    public void testSaveNewUser(User user){
        assertTrue(userService.saveNewEntry(user));
    }


    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1,1.2",
            "2,2,4"
    })

    public void test(int a,int b,int expected){
        assertEquals(expected,a+b);
    }


}
