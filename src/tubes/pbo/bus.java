package tubes.pbo;



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
}