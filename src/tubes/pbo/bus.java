package tubes.pbo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class bus {
    private int id_bus;
    private int no_bus;
    
    public bus(){
        
    }
    
    public bus(int id_bus, int no_bus)
    {
        setId_bus(id_bus);
        setNo_bus(no_bus);
    }
    
    public void setId_bus(int id_bus)
    {
        this.id_bus = id_bus;
    }
    
    public int getId_bus()
    {
        return id_bus;
    }
    
    public void setNo_bus(int no_bus)
    {
        this.no_bus = no_bus;
    }
    
    public int getNo_bus()
    {
        return no_bus;
    }
    
    public void tambah_bus(String nobus, String dari, String ke, String tanggal, String tipe){
        try {
            // TODO add your handling code here:
            Class.forName("com.mysql.jdbc.Driver");
            Connection con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/newshantika", "root", "");
            String sql =  "INSERT INTO `busdatabase`(`NoBus`, `Asal`, `Tujuan`, `Tanggal`, `tipe`, `Status`) VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
         

            pst.setString(1, nobus);
            pst.setString(2, dari);
            pst.setString(3, ke);
            pst.setString(4, tanggal);
            pst.setString(5, tipe);
            pst.setString(6, "Belum Berangkat");
            
            if(pst.executeUpdate()> 0){
                JOptionPane.showMessageDialog(null, "Bus baru berhasil ditambahkan");
                con.close();
            }
            
        }catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "Nomor bus sudah terdaftar, silahkan ganti");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String[] current_bus() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/newshantika", "root", "");
        String  sql = "SELECT NoBus from busdatabase";
        PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        String[] tbData = new String[50];
        int i = 0;
        while(rs.next()){
            String tiket = rs.getString("NoBus");
            tbData[i] = tiket;
            i++;
        }
        
        return tbData;
    }
    
    public int harga_bus(String asal, String ke, String tipe) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/newshantika", "root", "");
        String  sql = "SELECT harga from hargadatabase where asal_bus = ? and ke_bus = ? and tipe = ?";
        PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
        pst.setString(1, asal);
        pst.setString(2, ke);
        pst.setString(3, tipe);
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            return rs.getInt("harga");
        } else {
            return 0;
        }
        
    }
    
    public boolean ada_destinasi(String asal, String ke) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/newshantika", "root", "");
        String  sql = "SELECT * from hargadatabase where  `asal_bus` = ? and `ke_bus` = ?";
        PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
        pst.setString(1, asal);
        pst.setString(2, ke);
        ResultSet rs = pst.executeQuery();
        
        return rs.next();
    }
    
    
}