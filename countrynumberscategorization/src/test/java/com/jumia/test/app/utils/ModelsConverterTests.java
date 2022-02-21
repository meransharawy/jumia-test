package com.jumia.test.app.utils;

import com.jumia.test.app.db.model.DbCustomer;
import com.jumia.test.app.model.Customer;
import com.jumia.test.app.validator.MoroccoPhoneNumberValidator;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@AutoConfigureMockMvc
class ModelsConverterTests {

    @Autowired
    ModelsConverter modelsConverter;

    @MockBean
    MoroccoPhoneNumberValidator moroccoPhoneNumberValidator;

    @Test
    void mapDbCustomerToCustomer_throwsException() throws IllegalArgumentException {

        DbCustomer dbCustomer = new DbCustomer();
        dbCustomer.setId(0);
        dbCustomer.setName("meran");
        dbCustomer.setPhone("(0020) 1063009917");

        assertThrows(IllegalArgumentException.class,
                () -> modelsConverter.mapDbCustomerToCustomer(dbCustomer));

    }

    @Test
    void mapDbCustomerToCustomer_Success() throws IllegalArgumentException {

        when(moroccoPhoneNumberValidator.validatePhoneNumber(ArgumentMatchers.anyString())).thenReturn(false);

        DbCustomer dbCustomer = new DbCustomer();
        dbCustomer.setId(0);
        dbCustomer.setName("meran");
        dbCustomer.setPhone("(212) 6007989253");

        Customer actual = modelsConverter.mapDbCustomerToCustomer(dbCustomer);

        Customer expected = Customer.builder().customerName("meran").countryCode("212")
                .state(false).phoneNumber("(212) 6007989253").countryName("Morocco").build();

        assertEquals(actual, expected);

    }

}
