package com.jumia.test.app.db.dao;

import com.jumia.test.app.db.model.DbCustomer;
import com.jumia.test.app.rowmapper.CustomerRowMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class CustomerDaoTests {

    @Autowired
    CustomerDao customerDao;

    @Mock
    JdbcTemplate jdbcTemplate;

    @Test
     void whenMockJdbcTemplate_thenReturnCorrectEmployeeCount() {

        ReflectionTestUtils.setField(customerDao, "jdbcTemplate", jdbcTemplate);
        final String query = "SELECT * FROM customer" ;
        List<DbCustomer> dbCustomers = new ArrayList<>();
        dbCustomers.add(DbCustomer.builder().name("meran").phone("(256) 7503O6263").id(0).build());
        Mockito.when(jdbcTemplate.query(query, new CustomerRowMapper()))
                .thenReturn(dbCustomers);
        assertNotNull(customerDao.getAllCustomers());
    }
}
