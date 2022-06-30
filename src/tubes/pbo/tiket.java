package tubes.pbo;
public class tiket {
     private int id_tiket;
    private int no_tiket;
    
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
}
