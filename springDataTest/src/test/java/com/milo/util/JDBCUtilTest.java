package com.milo.util;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by milo on 17-6-11.
 */
public class JDBCUtilTest {

    @Test
    public void testGetConnection() throws SQLException, ClassNotFoundException, IOException {
        Connection connection = JDBCUtil.getConnection();
        Assert.assertNotNull(connection);
    }

}
