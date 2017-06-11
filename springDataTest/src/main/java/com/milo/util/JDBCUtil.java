package com.milo.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by milo on 17-6-11.
 */
public class JDBCUtil {


    /**
     * get the jdbc connect
     * @return
     */
    public static Connection getConnection() throws ClassNotFoundException, SQLException, IOException {

//        String url = "jdbc:postgresql://127.0.0.1:5432/sampledb";
//        String user = "milodb";
//        String password = "1234";
//        String driverClass = "org.postgresql.Driver";

        InputStream inputStream = JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");

        Properties properties = new Properties();
        properties.load(inputStream);

        String url = properties.getProperty("jdbc.url");
        String user = properties.getProperty("jdbc.user");
        String password = properties.getProperty("jdbc.password");
        String driverClass = properties.getProperty("jdbc.driverClass");

        Class.forName(driverClass);
        Connection connection = DriverManager.getConnection(url,user,password);
        return  connection;
    }


    /**
     * release db resource
     * @param resultSet
     * @param statement
     * @param connection
     */
    public static void release(ResultSet resultSet,
                               Statement statement,
                               Connection connection){
        if(resultSet != null){
            try {
                resultSet.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(statement != null){
            try {
                statement.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(connection != null){
            try {
                connection.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
