package com.jumia.test.app.rowmapper;

import com.jumia.test.app.db.model.DbCustomer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper<DbCustomer> {

    @Override
    public DbCustomer mapRow(ResultSet rs, int rowNum) throws SQLException {
        DbCustomer customer = new DbCustomer();
        customer.setId(rs.getInt("id"));
        customer.setName(rs.getString("name"));
        customer.setPhone(rs.getString("phone"));
        return customer;
    }
}
