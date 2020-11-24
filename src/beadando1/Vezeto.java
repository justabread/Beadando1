package beadando1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Vezeto extends BerlesSzervezo {

    private int accountBalance = 5000000;

    public Vezeto() {
        this.password = "vez";
    }

    public void addCar() {
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
            output.write(license + ";" + brand + ";" + type + ";" + price + "\n");
        } catch (IOException ex) {
            Logger.getLogger(Vezeto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void removeCar() {
        Scanner input = new Scanner(System.in);
        System.out.println("rendszám:");
        String license = input.nextLine();
        Osztalykezelo o = new Osztalykezelo();
        o.jarmuRead();
        for (int i = 0; i < o.getJarmuList().size(); i++) {
            if (o.getJarmuList().get(i).getLicense().equals(license)) {
                o.getJarmuList().remove(i);
                break;
            } else if (i == o.getJarmuList().size() - 1) {
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

    public void salary() {

        //accountBalance -= 
    }

    public void costs() {
        accountBalance -= 500000;
    }

    public void income() {

    }

    public void addEmployee() {
        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        System.out.println("alkalmazott azonosítója:");
        int id = scan1.nextInt();
        System.out.println("alkalmazott neve:");
        String name = scan2.nextLine();
        Osztalykezelo o = new Osztalykezelo();
        o.alkalmazottRead();
        boolean foglalt = false;
        for (Alkalmazott a : o.getAlkalmazottList()) {
            if (a.getEmployeeId() == id) {
                System.out.println("Ez azonosító már foglalt.");
                foglalt = true;
            }
        }
        if (!foglalt) {
            Alkalmazott a = new Alkalmazott(id, name);
            a.ujAlkalmazottBejegyzese();
        }
    }

    public void removeEmployee() {
        Scanner input1 = new Scanner(System.in);
        System.out.println("alkalmazott azonosítója:");
        int eId = input1.nextInt();
        Osztalykezelo o = new Osztalykezelo();
        o.alkalmazottRead();
        for (int i = 0; i < o.getAlkalmazottList().size(); i++) {
            if (o.getAlkalmazottList().get(i).getEmployeeId() == eId) {
                o.getAlkalmazottList().remove(i);
                break;
            } else if (i == o.getAlkalmazottList().size() - 1) {
                System.out.println("Nincs ilyen azonosítójú alkalmazott a rendszerben.");
                break;
            }
        }

        try (BufferedWriter output = new BufferedWriter(new FileWriter("alkalmazottFile.txt", false))) {
            for (Alkalmazott a1 : o.getAlkalmazottList()) {
                output.write(a1.getEmployeeId() + ";" + a1.getEmployeeName() + "\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(Vezeto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
