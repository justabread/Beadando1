package beadando1;

import java.util.Scanner;

public class Ugyfel {
    private final String name;
    private final int ugyfelId;

    public Ugyfel(int ugyfelId, String name) {
        this.name = name;
        this.ugyfelId = ugyfelId;
    }
    
    public int getUgyfelId()
    {
        return this.ugyfelId;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public void complaint(){
        Scanner sc = new Scanner(System.in);
    }
    
    public void newRent(){}
    
    public void editRent(){}
    
    public void searchCar(){}
    
    public String ugyfelToString()
    {
        return this.ugyfelId + "; " + this.name;
    }  
}
