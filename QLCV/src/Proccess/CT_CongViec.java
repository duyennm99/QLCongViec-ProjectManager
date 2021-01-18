/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proccess;
import com.sun.org.apache.xerces.internal.impl.dv.xs.DecimalDV;
import database.connectionDB;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Endy
 */
public class CT_CongViec {
     public connectionDB cn = new connectionDB();

    //Truy van tat ca du lieu trong Table LoaiSP
    public ResultSet ShowCTCongviec() throws SQLException{
        cn.connectionDB();
        String sql = "SELECT TIENDOCONGVIEC,MUCDOHOANTHANH, c.MACV, c.TENCV FROM CT_CONGVIEC ct, CONGVIEC c where c.MACV = ct.MACV";

        return cn.GetDB(sql);
    }
    
    public ResultSet ShowCongviec() throws SQLException{
        cn.connectionDB();
        String sql = "SELECT * FROM CONGVIEC";
        return cn. GetDB(sql);
    }
    
    public ResultSet ShowCongViec(String macv) throws SQLException {
        cn.connectionDB(); 
        String sql = "SELECT * FROM CONGVIEC where MACV = '" + macv + "'";
        return cn. GetDB(sql);
    }
    
    public ResultSet ShowCTCongviecTheoten (String ten) throws SQLException{
        String sql = "SELECT TIENDOCONGVIEC, MUCDOHOANTHANH, c.MACV, c.TENCV FROM CT_CONGVIEC ct, CONGVIEC c where c.MACV= ct.MACV and TENCV like % " + ten + "%";
        return cn. GetDB(sql);
    }
    
     //Theo moi l dong du lieu vao table LoaiSP
    public void InsertData(String macv, String tiendocv, double mucdoht) throws SQLException {
        
        String sql = "INSERT INTO CT_CONGVIEC values('" + macv + "', N'"+ tiendocv +"', N'"+ mucdoht+"')"; 
        cn.UpdateDB(sql);    
    }
    
    //Dieu chinh l dong du lieu vao table LoaiSP
    public void EditData (String macv, String tiendocv, double mucdoht) throws SQLException { 
        String sql = "Update CT_CONGVIEC set TIENDOCONGVIEC= N'" + tiendocv + "', MUCDOHOANTHANH= '"+ mucdoht +"', where MACV='" + macv + ""; 
        cn. UpdateDB(sql);
    }
    
    //Xoa i dong du lieu vao table Loais
    public void DeleteData (String macv) throws SQLException{
        String sql = "Delete from CT_CONGVIEC where MACV = '" + macv +"'";
        cn. UpdateDB(sql);
    }
    
    
}
