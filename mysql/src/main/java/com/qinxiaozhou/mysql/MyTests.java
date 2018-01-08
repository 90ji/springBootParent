package com.qinxiaozhou.mysql;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.CallableStatement;
import java.sql.SQLException;

/**
 * @Author MoonLion
 * @Date Create in 2017/12/14 0014
 * @Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTests {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testCallableStatementCreator3() {
        final String callProcedureSql = "{call TEST_UPDATE_PROC(?, ?)}";
        final int token = 1;
        final String userName = "world";

        jdbcTemplate.execute(callProcedureSql, new CallableStatementCallback<Void>() {
            public Void doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                cs.setInt(1, token);
                cs.setString(2, userName);
                cs.execute();
                return null;
            }
        });
    }
}
