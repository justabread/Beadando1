package beadando1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Vezeto extends BerlesSzervezo {

    private int accountBalance;
    private Osztalykezelo o;

    public Vezeto(Osztalykezelo _o) {
        this.password = "vez";
        this.o = _o;
        accountBalanceRead();
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

    public void income(int currentYear,int currentMonth) {
        int currentMonthPrice = 0;
        boolean hasFound = false;
        Scanner in = new Scanner(System.in);
        
        for(Map.Entry<Integer, Berles> currentBerles : o.getBerlesMap().entrySet()) {
            if(currentBerles.getValue().getStartDate().getYear() == currentYear && currentBerles.getValue().getStartDate().getMonthValue() == currentMonth)
            {
                currentMonthPrice += currentBerles.getValue().getTotalPrice();
                hasFound = true;
            }                
        }
        
        if(!hasFound)
        {
            System.out.println("A megadott időpont nem szerepel a tárolt bérlések között.");
            System.out.println("Kérem adjon meg egy évet:");      
            int ev = in.nextInt();
            System.out.println("Kérem adjon meg egy hónapot:");      
            int honap = in.nextInt();

            income(ev, honap);
        }

        System.out.println("A számláján " + accountBalance + "ft összeg található.");
        System.out.println("A megadott hónapban " + currentMonthPrice + "ft bevétel van tárolva. Hozzá kívánja adni a számlájához?(Y/N)");
        
        String userInput = in.nextLine();
        switch(userInput.toLowerCase())
        {
            case "y":
                accountBalance += currentMonthPrice;
                
                try {
                    FileWriter myWriter = new FileWriter("vezetoBalance.txt");
                    myWriter.write(String.valueOf(accountBalance));
                    System.out.println("Havi bevétel sikeresen hozzáadva a számlához.");
                    
                    myWriter.close();
                } catch (IOException e) {
                    System.out.println("An error occurred while writing to vezetoBalance.txt");
                }
                break;
            case "n":
                System.out.println("Művelet visszavonva.");
                break;
            default:
                System.out.println("A bemenet nem ismerhető fel.");
                break;
        }       
    }

    public void addEmployee() {
        o.alkalmazottRead();
        Scanner scan2 = new Scanner(System.in);
        int id = 1;
        if(o.getAlkDb() >= 1){
            id = o.getAlkalmazottList().get(o.getAlkDb()-1).getEmployeeId() + 1;
        }
        System.out.println("Alkalmazott neve:");
        String name = scan2.nextLine();
        Alkalmazott a = new Alkalmazott(id, name, o);
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
    
    public void accountBalanceRead()
    {
        try{
            File vezetoFile = new File("vezetoBalance.txt");
            Scanner vezetoRead = new Scanner(vezetoFile);
            while(vezetoRead.hasNextLine())
            {
                String currentLine = vezetoRead.nextLine();
                accountBalance = Integer.parseInt(currentLine);
            }
        }catch(FileNotFoundException e)
        {
            System.out.println("Error: vezetoBalance.txt not found");
        }    
    }
}
