/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Endy
 */
public class connectionDB {
    String connectionString = "jdbc:sqlserver://localhost:1433;" 
            + "databaseName=QLCV;user=sa;password=qn261099;";
    Connection conn;
    
    public void connectionDB(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(connectionString);
            
            if(conn != null){
                System.out.println("Kết nối CSDL SQL Server thành công!");
            }
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    //Thực thi câu lệnh SELECT
    public ResultSet GetDB(String sql){
        try {
            Statement stmt = conn.createStatement();           
            ResultSet rs = stmt.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
            
        return null;
    }
    
    //Thực thi INSERT, DELETE, UPDATE
    public void UpdateDB(String sql){
       
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    
}
