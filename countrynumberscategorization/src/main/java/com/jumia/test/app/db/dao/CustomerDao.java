package com.jumia.test.app.db.dao;

import com.jumia.test.app.db.model.DbCustomer;
import com.jumia.test.app.rowmapper.CustomerRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<DbCustomer> getAllCustomers() {
        List<DbCustomer> dbCustomers;
        final String query = "SELECT * FROM customer" ;
        dbCustomers = jdbcTemplate.query(query, new CustomerRowMapper());
        return dbCustomers;
    }

}
