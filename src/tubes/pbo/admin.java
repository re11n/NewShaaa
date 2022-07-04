/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes.pbo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ryans
 */
public class admin extends user{
    
    public admin(){
        
    }
    
    public admin(String username, String password)
    {
        setUsername(username);
        setPassword(password);
    }
    
    public boolean is_admin(String username) throws ClassNotFoundException, SQLException{
               Class.forName("com.mysql.jdbc.Driver");
               Connection con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/newshantika", "root", "");
               String sql = "select adm from logindatabase where username=?";
               PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
               pst.setString(1, username);
               ResultSet rs = pst.executeQuery();
               
               rs.next();
               String admi = rs.getString("adm");
               if("no".equals(admi)){
                   return false;
               } else {
                   return true;
               }
    }
    
    public String selected_user() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/newshantika", "root", "");
        String  sql = "SELECT * from selected";
        PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        
        rs.next();
        String user = rs.getString("activeuser");
        con.close();
        return user;
    }
    
    public String[] detail_user(String username) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/newshantika", "root", "");
        String  sql = "SELECT * from logindatabase where username = ?";
        PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
        pst.setString(1, username);
        ResultSet rs = pst.executeQuery();
        String[] tbData = new String[50];
        while(rs.next()){
            String id = rs.getString("id");
            String nama = rs.getString("nama");
            String username1 = rs.getString("username");
            String notelp = rs.getString("no_telp");
            tbData[0] = id;
            tbData[1] = nama;
            tbData[2] = username1;
            tbData[3] = notelp;
        }
        
        return tbData;
    }
    
    
    public void hapus_user(String id){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/newshantika", "root", "");
            String sql1 = "delete from `logindatabase` where id= ?";
            PreparedStatement pst1 = (PreparedStatement) con.prepareStatement(sql1);
            pst1.setString(1, id);
            pst1.executeUpdate();
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void hapus_bus(String nobus){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/newshantika", "root", "");
            String sql1 = "delete from `busdatabase` where NoBus= ?";
            PreparedStatement pst1 = (PreparedStatement) con.prepareStatement(sql1);
            pst1.setString(1, nobus);
            pst1.executeUpdate();
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
