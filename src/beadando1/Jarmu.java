package beadando1;

public class Jarmu {
    private String type;
    private String license;
    private String brand;
    private int price;
    
    public Jarmu(String _license, String _brand, String _type, int _price)
    {
        this.type = _type;
        this.license = _license;
        this.brand = _brand;
        this.price = _price;
    }
    
    public String getType()
    {
        return this.type;
    }
    
    public String getLicense()
    {
        return this.license;
    }
    
    public String getBrand()
    {
        return this.brand;
    }
    
    public int getPrice()
    {
        return this.price;
    }
    
    public String jarmuToString()
    {
        return this.license + "; " + this.brand + "; " + this.type + "; " + this.price;
    }   
}
