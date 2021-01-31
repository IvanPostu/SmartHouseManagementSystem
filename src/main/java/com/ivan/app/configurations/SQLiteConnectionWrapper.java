/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.app.configurations;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ivan
 */
public class SQLiteConnectionWrapper {
    private static SQLiteConnectionWrapper singleton = new SQLiteConnectionWrapper();
    private Connection jdbcConnection;
    
    private SQLiteConnectionWrapper(){
        String path = new File(".").getAbsolutePath();      
        String url = "jdbc:sqlite:"+path+"/appDB.db";
        
        try {
            Connection c = DriverManager.getConnection(url);
            jdbcConnection = c;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static SQLiteConnectionWrapper getInstance(){
        return singleton;
    }
    
    public Connection getConnection(){
        return jdbcConnection;
    }
    
}
