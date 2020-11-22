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
    }
    
    public void setVehicle(List<String> _vehicle)
    {
        vehicle = _vehicle;
    }
}
