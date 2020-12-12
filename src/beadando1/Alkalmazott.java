package beadando1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Alkalmazott extends BerlesSzervezo{
    private final int employeeId;
    private final String employeeName;
    private Osztalykezelo o;

    public Alkalmazott(int employeeId, String name, Osztalykezelo _o) {
        this.employeeId = employeeId;
        employeeName = name;
        this.password = "alk";
        this.o = _o;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }      
    
    public void listRents(){
        o.getBerlesMap().entrySet().forEach(currentBerles->{
            System.out.println(currentBerles.getKey() + "; " + currentBerles.getValue().berlesToString());
        });
    }
    
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
