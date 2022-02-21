package com.jumia.test.app.validator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
class MoroccoPhoneNumberValidatorTests {

    @Autowired
    MoroccoPhoneNumberValidator moroccoPhoneNumberValidator;

    @Test
    void validateMobileNumber_Success_returnFalse() throws IllegalArgumentException {

        Boolean valid = moroccoPhoneNumberValidator.validatePhoneNumber("(212) 6007989253");
        assertEquals(false, valid);

    }

    @Test
    void validateMobileNumber_Success_returnTrue() throws IllegalArgumentException {

        Boolean valid = moroccoPhoneNumberValidator.validatePhoneNumber("(212) 698054317");
        assertEquals(true, valid);

    }
}
