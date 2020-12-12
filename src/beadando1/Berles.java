package beadando1;

import java.util.ArrayList;
import java.util.List;      
import java.time.*;
        
public class Berles
{
    private int totalPrice;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<String> vehicle=new ArrayList<>();
    
    public Berles(int _totalPrice, LocalDate _startDate, LocalDate _endDate, List<String> _vehicle)
    {
        this.totalPrice = _totalPrice;
        this.startDate = _startDate;
        this.endDate = _endDate;
        vehicle = _vehicle;
    }   

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setVehicle(List<String> vehicle) {
        this.vehicle = vehicle;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public List<String> getVehicle() {
        return vehicle;
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
    
    public String berlesToStringNoPrice()
    {
        String berlesStringFirst = this.startDate + "; " + this.endDate; 
        for(String v : vehicle)
        {
            berlesStringFirst += "; " + v;
        }
        
        return berlesStringFirst;
    }
}
