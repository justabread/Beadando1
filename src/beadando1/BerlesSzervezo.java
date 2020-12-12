package beadando1;

public class BerlesSzervezo {
    protected String password;
    
    public boolean login(String pass)
    {
        return pass.equals(password);
    }
}
