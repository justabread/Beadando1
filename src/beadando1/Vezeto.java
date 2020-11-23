package beadando1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Vezeto extends BerlesSzervezo{
    
    private int accountBalance = 5000000;
    
    public Vezeto()
    {
        this.password = "vez";
    }
    public void addCar()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("rendszám:");
        String license = sc.nextLine();
        System.out.println("gyártó:");
        String brand = sc.nextLine();
        System.out.println("típus:");
        String type = sc.nextLine();
        System.out.println("napidíj:");
        int price = sc.nextInt();
        try (BufferedWriter output = new BufferedWriter(new FileWriter("jarmuFile.txt", true))) {
            output.write(license+ ";" + brand + ";" + type + ";" + price + "\n");
        } catch (IOException ex) {
            Logger.getLogger(Vezeto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void removeCar()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("rendszám:");
        String license = input.nextLine();
        Osztalykezelo o = new Osztalykezelo();
        o.jarmuRead();
        for(int i = 0; i < o.getJarmuList().size(); i++){
            if(o.getJarmuList().get(i).getLicense().equals(license)){
                o.getJarmuList().remove(i);
                break;
            }
            else if(i == o.getJarmuList().size()-1){
                System.out.println("Nincs ilyen rendszámú autó a rendszerben.");
                break;
            }
        }
        
        try (BufferedWriter output = new BufferedWriter(new FileWriter("jarmuFile.txt", false))) {
            for (Jarmu j1 : o.getJarmuList()) {
                output.write(j1.getLicense() + ";" + j1.getBrand() + ";" + j1.getType() + ";" + j1.getPrice() + "\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(Vezeto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void salary()
    {
        
    }
    public void costs()
    {
        
    }
    public void income()
    {
        
    }
    public void addEmployee()
    {
        
    }
    public void removeEmployee()
    {
        
    }
}
