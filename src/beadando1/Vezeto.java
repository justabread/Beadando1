package beadando1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Vezeto extends BerlesSzervezo {

    private int accountBalance;

    public Vezeto() {
        this.password = "vez";
        accountBalance = 5000000;
    }

    public void addCar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Rendszám:");
        String license = sc.nextLine();
        System.out.println("Gyártó:");
        String brand = sc.nextLine();
        System.out.println("Típus:");
        String type = sc.nextLine();
        int price = -1;
        boolean validEntry;
        do {
            try {
                System.out.println("Napidíj:");
                Scanner scan = new Scanner(System.in);
                price = scan.nextInt();
                validEntry = true;
            } catch (InputMismatchException e) {
                validEntry = false;
                System.out.println("Kérem egész számot üssön be!");
            }
        } while (!validEntry);
        try (BufferedWriter output = new BufferedWriter(new FileWriter("jarmuFile.txt", true))) {
            if (price >= 0) {
                output.write(license + ";" + brand + ";" + type + ";" + price + "\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(Vezeto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void removeCar() {
        Scanner input = new Scanner(System.in);
        System.out.println("Rendszám:");
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
        Osztalykezelo o = new Osztalykezelo();
        o.alkalmazottRead();
        int db = o.getAlkalmazottList().size();
        if (accountBalance >= db * 200000) {
            accountBalance -= db * 200000;
            System.out.println("Sikeres utalás! Jelenlegi egyenlege: " + accountBalance + " Ft.");
        } else {
            System.out.println("Az utalás sikertelen! Nincs elég pénz a számláján.");
        }
    }

    public void costs() {
        if (accountBalance >= 500000) {
            accountBalance -= 500000;
            System.out.println("Sikeres utalás! Jelenlegi egyenlege: " + accountBalance + " Ft.");
        } else {
            System.out.println("Az utalás sikertelen! Nincs elég pénz a számláján.");
        }
    }

    public void income() {

    }

    public void addEmployee() {
        Osztalykezelo o = new Osztalykezelo();
        o.alkalmazottRead();
        Scanner scan2 = new Scanner(System.in);
        int id = 1;
        if(o.getAlkDb() >= 1){
            id = o.getAlkalmazottList().get(o.getAlkDb()-1).getEmployeeId() + 1;
        }
        System.out.println("Alkalmazott neve:");
        String name = scan2.nextLine();
        Alkalmazott a = new Alkalmazott(id, name);
        a.ujAlkalmazottBejegyzese();
    }

    public void removeEmployee() {
        Scanner input1 = new Scanner(System.in);
        //System.out.println("alkalmazott azonosítója:");
        //int eId = input1.nextInt();
        int eId = 0;
        boolean validEntry;
        do {
            try {
                System.out.println("Alkalmazott azonosítója:");
                eId = input1.nextInt();
                validEntry = true;
            } catch (InputMismatchException e) {
                validEntry = false;
                System.out.println("Kérem egész számot üssön be!");
            }
        } while (!validEntry);

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
