package org.zerock.persistence;

import lombok.extern.log4j.Log4j;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.Assert.fail;

@Log4j
public class JDBCTest {
    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void testConnection() {
        try(Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "passwd")){
            log.info(con);
        }catch (Exception e){
            fail(e.getMessage());
        }
    }
}
