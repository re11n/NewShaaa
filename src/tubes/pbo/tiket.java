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
    
    public void pesanTiket(String nama, String no_telp, String dari, String ke, String promo, String tanggal, int kursi){

        try {
            if("premium".equals(promo)){
                promo = "yes";
            } else{
                promo = "no";
            }
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/newshantika", "root", "");
            String sql =  "INSERT INTO `tiketdatabase`(`user`, `nama`, `no_telp`, `bus_dari`, `bus_ke`, `kursi`, `premium`, `sudah_bayar`) VALUES (?,?,?,?,?,?,?,?)";
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
            
            if(pst.executeUpdate()> 0){
                JOptionPane.showMessageDialog(null, "Tiket telah dibuat, silahkan ke menu pembayaran");
            }
            con.close();
            
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
    
    public int harga_tiket(String premium){
        int harga = 250000;
        
        if("yes".equals(premium)){
            harga = 200000;
        }
        
        return harga;
    }

}
