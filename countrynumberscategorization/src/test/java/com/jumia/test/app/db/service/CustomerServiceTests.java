package com.jumia.test.app.db.service;

import com.jumia.test.app.db.dao.CustomerDao;
import com.jumia.test.app.db.model.DbCustomer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class CustomerServiceTests {

    @MockBean
    CustomerDao customerDao;

    @Autowired
    CustomerService customerService;

    @Test
    void getAllCustomers_Success()  {

        List<DbCustomer> dbCustomers = new ArrayList<>();
        dbCustomers.add(DbCustomer.builder().name("meran").phone("(212) 6007989253").id(0).build());

        when(customerDao.getAllCustomers()).thenReturn(dbCustomers);

        assertNotNull(customerService.getAllCustomers());
    }
}
