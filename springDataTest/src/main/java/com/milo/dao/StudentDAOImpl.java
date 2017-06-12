package com.milo.dao;

import com.milo.domain.Student;
import com.milo.util.JDBCUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by milo on 17-6-11.
 */
public class StudentDAOImpl implements StudentDAO {
    @Override
    public List<Student> query() {
        List<Student> studentList = new ArrayList<>();

        String sql = "select id, name, password,age from t_spring_data";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            Student student = null;
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String password = resultSet.getString("password");

                student = new Student();

                student.setId(id);
                student.setAge(age);
                student.setName(name);
                student.setPassword(password);

                studentList.add(student);

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(resultSet,preparedStatement,connection);
        }

        return studentList;
    }

    @Override
    public void save(Student student) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "insert INTO t_spring_data(name,password,age) values(?,?,?)";

        try{
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getPassword());
            preparedStatement.setInt(3,student.getAge());
            preparedStatement.execute();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(resultSet,preparedStatement,connection);
        }

    }
}
