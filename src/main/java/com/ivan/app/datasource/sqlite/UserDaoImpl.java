/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.app.datasource.sqlite;

import com.ivan.app.datasource.UserDao;
import com.ivan.app.datasource.entity.UserEntity;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

/**
 *
 * @author User
 */
public class UserDaoImpl implements UserDao {

    Connection connection;

    public UserDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<UserEntity> selectUserByUsername(String username) {
        try ( Statement statement = connection.createStatement()) {

            String sql = String.format("SELECT username, password, first_name, last_name "
                    +" FROM users WHERE username='%s'", username);
            
            /**
             * Single result
             */
            ResultSet rs = statement.executeQuery(sql);
            UserEntity user = new UserEntity();
            
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setFirstName(rs.getString("first_name"));            
            user.setLastName(rs.getString("last_name"));
            
            return Optional.of(user);
        } catch (SQLException ex) {
            return Optional.empty();
        }
    }

    @Override
    public void insertUser(UserEntity user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteUserByUsername(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
