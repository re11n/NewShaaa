package tubes.pbo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class member extends user{

    public member(){
        
    }
    public member(String username, String password)
    {
        setUsername(username);
        setPassword(password);
    }
    
    public String user_current() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/newshantika", "root", "");
        String  sql = "SELECT * from user";
        PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        
        rs.next();
        String user = rs.getString("current");
        con.close();
        return user;
    }    
    public void current(String username){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/newshantika", "root", "");
            String sql1 = "truncate `user`";
            PreparedStatement pst1 = (PreparedStatement) con.prepareStatement(sql1);
            pst1.executeUpdate();
            String sql = "insert into `user`(`current`) VALUES (?)";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, username);
            pst.executeUpdate();
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(member.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(member.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public String ambil_noTelp(String username) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/newshantika", "root", "");
        String  sql = "SELECT no_telp from logindatabase where username=?";
        PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
        pst.setString(1, username);
        ResultSet rs = pst.executeQuery();
        rs.next();
        String user = rs.getString("no_telp");
        con.close();
        return user;
    }
    
    public void bayar_tiket(String id_tiket){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/newshantika", "root", "");
            String sql = "update tiketdatabase SET sudah_bayar = 'yes' where id_tiket = ?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, id_tiket);
            pst.executeUpdate();
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(member.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(member.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
