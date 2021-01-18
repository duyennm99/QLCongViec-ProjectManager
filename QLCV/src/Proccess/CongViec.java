/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proccess;
import database.connectionDB;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Endy
 */
public class CongViec {
    public connectionDB cn = new connectionDB();
    
    public ResultSet ShowCongViec() throws SQLException{
        cn.connectionDB();
        String sql = "SELECT * FROM CONGVIEC";
        return cn.GetDB(sql);
    }
    
    public ResultSet ShowCongViec(String macv) throws SQLException {
        cn.connectionDB();
        String sql = "SELECT * FROMCONGVIEC where MACV='" + macv + "'"; 
        return cn.GetDB(sql);
    }
    
        //Theo moi l dong du lieu vao table LoaiSP
    public void InsertData(String macv, String tencv, String mota) throws SQLException {
        
        String sql = "INSERT INTO CONGVIEC values('" + macv + "', N'" + tencv + "', N'" + mota + "')"; 
        cn.UpdateDB(sql);    
    }
    
    //Dieu chinh l dong du lieu vao table LoaiSP
    public void EditData (String macv, String tencv, String mota) throws SQLException { 
        String sql = "Update CONGVIEC set TENCV= N'" + tencv + "', MOTA= N'" + mota + "' where MACV='" + macv + "'"; 
        cn. UpdateDB(sql);
    }
    
    //Xoa i dong du lieu vao table Loais
    public void DeleteData (String macv) throws SQLException{
        String sql = "Delete from CONGVIEC where MACV = '" + macv +"'";
        cn. UpdateDB(sql);
    }

    public void cbxMacvActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }
}
