package beadando1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Alkalmazott extends BerlesSzervezo{
    private final int employeeId;
    private final String employeeName;

    public Alkalmazott(int employeeId, String name) {
        this.employeeId = employeeId;
        employeeName = name;
        this.password = "alk";
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }
    
    
    public void manageCar(){}
    
    public void contact(){}
    
    public void listRents(){}
    
    public void ujAlkalmazottBejegyzese(){
        try (BufferedWriter output = new BufferedWriter(new FileWriter("alkalmazottFile.txt", true))) {
            output.write(employeeId + ";" + employeeName + "\n");
        } catch (IOException ex) {
            Logger.getLogger(Vezeto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String alkalmazottToString(){
        return employeeId + ";" + employeeName;
    }
}
