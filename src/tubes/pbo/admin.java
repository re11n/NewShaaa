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
}
