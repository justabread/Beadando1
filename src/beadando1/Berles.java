package beadando1;

import java.util.ArrayList;
import java.util.List;      
import java.time.*;
        
public class Berles
{
    private int totalPrice;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<String> vehicle=new ArrayList<String>();
    
    public Berles(int _totalPrice, LocalDate _startDate, LocalDate _endDate, List<String> _vehicle)
    {
        this.totalPrice = _totalPrice;
        this.startDate = _startDate;
        this.endDate = _endDate;
        vehicle = _vehicle;
    }   
    
    public String berlesToString()
    {
        String berlesStringFirst = this.totalPrice + "; " + this.startDate + "; " + this.endDate; 
        for(String v : vehicle)
        {
            berlesStringFirst += "; " + v;
        }
        
        return berlesStringFirst;
    }  
}
