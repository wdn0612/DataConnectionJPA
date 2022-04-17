package com.dntech.jpa;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class OrderDAO {

    private final JdbcTemplate jdbcTemplate;

    public OrderDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void updateOrderDateByUserId(String userId, String newOrderDate) throws SQLException {
        final String sql = "UPDATE java_cache.order_details SET order_date=? WHERE user_id=?";
        PreparedStatementCreator creator = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, newOrderDate);
                ps.setString(2, userId);
                return ps;
            }
        };

        this.jdbcTemplate.execute(creator, new PreparedStatementCallback<String>() {
            @Override
            public String doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ps.executeUpdate();
                return "SUCCESS";
            }
        });
    }
}
