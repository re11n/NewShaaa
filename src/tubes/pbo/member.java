package tubes.pbo;

public class member {
    private String username;
    private String password;
    
    public member(){
        
    }
    public member(String username, String password)
    {
        setUsername(username);
        setPassword(password);
    }
    
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void tampil_login(){
        new LoginForm().setVisible(true);
        
    }
    
    public void user(){
        
    }
}
