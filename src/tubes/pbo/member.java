package tubes.pbo;
public class member {
     private int id_member;
    private String nama_member;
    private int umur_member;
    
    public member(int id_member, String nama_member, int umur_member)
    {
        setId_member(id_member);
        setNama_member(nama_member);
        setUmur_member(umur_member);
    }
    
    public void setId_member(int id_member)
    {
        this.id_member = id_member;
    }
    
    public int getId_member()
    {
        return id_member;
    }
    
    public void setNama_member(String nama_member)
    {
        this.nama_member = nama_member;
    }
    
    public String getNama_member()
    {
        return nama_member;
    }
    
    public void setUmur_member(int umur_member)
    {
        this.umur_member = umur_member;
    }
    
    public int getUmur_member()
    {
        return umur_member;
    }
    
    //public void 
}
