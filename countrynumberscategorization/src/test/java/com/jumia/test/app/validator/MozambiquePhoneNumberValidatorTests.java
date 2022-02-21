package com.jumia.test.app.validator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
class MozambiquePhoneNumberValidatorTests {

    @Autowired
    MozambiquePhoneNumberValidator mozambiquePhoneNumberValidator;

    @Test
    void validateMobileNumber_Success_returnFalse() throws IllegalArgumentException {

        Boolean valid = mozambiquePhoneNumberValidator.validatePhoneNumber("(212) 6007989253");
        assertEquals(false, valid);

    }

    @Test
    void validateMobileNumber_Success_returnTrue() throws IllegalArgumentException {

        Boolean valid = mozambiquePhoneNumberValidator.validatePhoneNumber("(258) 847651504");
        assertEquals(true, valid);

    }
}
