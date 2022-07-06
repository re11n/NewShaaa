package tubes.pbo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.util.Arrays;

public class tiket {
    private int id_tiket;
    private int no_tiket;
    
    public tiket(){
        
    }
    
    public tiket(int id_tiket, int no_tiket)
    {
        setId_tiket(id_tiket);
        setNo_tiket(no_tiket);
    }
    
    public void setId_tiket(int id_tiket)
    {
        this.id_tiket = id_tiket;
    }
    
    public int getId_tiket()
    {
        return id_tiket;
    }
    
    public void setNo_tiket(int no_tiket)
    {
        this.no_tiket = no_tiket;
    }
    
    public int getNo_tiket()
    {
        return no_tiket;
    }
    
    public void pesanTiket(String nama, String no_telp, String dari, String ke, String promo, String tanggal, int kursi, String tipe){
        try {
            if(ada_bus(dari, ke, tanggal)){
                if(ada_kursi(kursi, dari, ke)){
                    if(ada_tipe(tipe, dari, ke)){
                        try {
                            if("premium".equals(promo)){
                            promo = "yes";
                            } else{
                               promo = "no";
                            }
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/newshantika", "root", "");
                            String sql =  "INSERT INTO `tiketdatabase`(`user`, `nama`, `no_telp`, `bus_dari`, `bus_ke`, `kursi`, `premium`, `sudah_bayar`, `tipe`) VALUES (?,?,?,?,?,?,?,?,?)";
                            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
                            String user = new member().user_current();
                            pst.setString(1, user);
                            pst.setString(2, nama);
                            pst.setString(3, no_telp);
                            pst.setString(4, dari);
                            pst.setString(5, ke);
                            pst.setInt(6, kursi);
                            pst.setString(7, promo);
                            pst.setString(8, "no");
                            pst.setString(9, tipe);
                    
                            if(pst.executeUpdate()> 0){
                                JOptionPane.showMessageDialog(null, "Tiket telah dibuat, silahkan ke menu pembayaran");
                            }
                            con.close();
                    
                            } catch (ClassNotFoundException | SQLException ex) {
                            Logger.getLogger(tiket.class.getName()).log(Level.SEVERE, null, ex);
                            }
                    } else{
                        JOptionPane.showMessageDialog(null, "Tipe untuk bus ini tidak tersedia, silahkan pilih tipe yang lain");
                    }
                    
                } else{
                    JOptionPane.showMessageDialog(null, "Kursi sudah terisi, silahkan pilih nomor kursi lain");
                }
            } else{
                JOptionPane.showMessageDialog(null, "Tidak dapat menemukan bus, mohon tunggu admin untuk menambahkan bus");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(tiket.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    
    public String[] current_tiket(String username) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/newshantika", "root", "");
        String  sql = "SELECT id_tiket from tiketdatabase where user = ? and sudah_bayar = 'no'";
        PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
        pst.setString(1, username);
        ResultSet rs = pst.executeQuery();
        String[] tbData = new String[50];
        int i = 0;
        while(rs.next()){
            String tiket = rs.getString("id_tiket");
            tbData[i] = tiket;
            i++;
        }
        
        return tbData;
    }
    
    public int harga_tiket(String premium, String dari, String ke, String tipe) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/newshantika", "root", "");
        String  sql = "SELECT harga from hargadatabase where asal_bus = ? and ke_bus = ? and tipe = ?";
        PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
        pst.setString(1, dari);
        pst.setString(2, ke);
        pst.setString(3, tipe);
        ResultSet rs = pst.executeQuery();
        int harga = 0;
        if(rs.next()){
            harga = rs.getInt("harga");
            if("yes".equals(premium)){
                harga = harga - 10000;
            }
        }
        

        
        return harga;
    }
    
    public boolean ada_bus(String asal, String ke, String tanggal) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/newshantika", "root", "");
        String  sql = "SELECT * from busdatabase where Asal = ? and Tujuan = ? and tanggal = ?";
        PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
        pst.setString(1, asal);
        pst.setString(2, ke);
        pst.setString(3, tanggal);
        ResultSet rs = pst.executeQuery();
        
        return rs.next();
    }
    
    public boolean ada_kursi(int kursi, String asal, String ke) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/newshantika", "root", "");
        String  sql = "SELECT * from tiketdatabase where kursi = ? and bus_dari = ? and bus_ke = ?";
        PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
        pst.setInt(1, kursi);
        pst.setString(2, asal);
        pst.setString(3, ke);
        ResultSet rs = pst.executeQuery();
        
        if(rs.next()){
            return false;
        } else{
            return true;
        }
    }
    
    public boolean ada_tipe(String tipe, String asal, String ke) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/newshantika", "root", "");
        String  sql = "SELECT * from busdatabase where tipe = ? and Asal = ? and Tujuan = ?";
        PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
        pst.setString(1, tipe);
        pst.setString(2, asal);
        pst.setString(3, ke);
        ResultSet rs = pst.executeQuery();
        
        return rs.next();
    }

    public String[] current_tiket_all(String username) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/newshantika", "root", "");
        String  sql = "SELECT id_tiket from tiketdatabase where user = ?";
        PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
        pst.setString(1, username);
        ResultSet rs = pst.executeQuery();
        String[] tbData = new String[50];
        int i = 0;
        while(rs.next()){
            String tiket = rs.getString("id_tiket");
            tbData[i] = tiket;
            i++;
        }
        
        return tbData;
    }
    
    public boolean ada_tipe_harga(String tipe, String asal, String ke) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/newshantika", "root", "");
        String  sql = "SELECT * from hargadatabase where `tipe` = ? and `asal_bus` = ? and `ke_bus` = ?";
        PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
        pst.setString(1, tipe);
        pst.setString(2, asal);
        pst.setString(3, ke);
        ResultSet rs = pst.executeQuery();
        
        return rs.next();
    }
}
