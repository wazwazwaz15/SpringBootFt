package org.example.springbootft;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PhoneRowMapper implements RowMapper<Phone> {

    @Override
    public Phone mapRow(ResultSet rs, int rowNum) throws SQLException {
       Phone phone = new Phone();
       phone.setId(rs.getInt("id"));
       phone.setColor(rs.getString("color"));
       phone.setPrice(rs.getBigDecimal("price"));
        return phone;
    }
}
