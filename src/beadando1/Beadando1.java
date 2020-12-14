package beadando1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Beadando1 {

    public static void main(String[] args) {
        Osztalykezelo o1 = new Osztalykezelo();
        o1.ugyfelRead();
        o1.jarmuRead();
        o1.berlesRead();
        Vezeto v = new Vezeto(o1);

        String valasztas = "";
        String valasz = "";
        String jelszo = "";
        Scanner sc = new Scanner(System.in);
        Alkalmazott a = new Alkalmazott(0, "", o1);

        while (!valasztas.equals("8")) {
            System.out.println("Opciók:");
            System.out.println("1. Új bérlés\n"
                    + "2. Meglévő bérlés szerkesztése\n"
                    + "3. Autók böngészése\n"
                    + "4. Reklamáció\n"
                    + "5. Bejelentkezés vezetőként\n"
                    + "6. Bejelentkezés alkalmazottként\n"
                    + "7. Kapcsolatfelvétel\n"
                    + "8. Kilépés\n"
                    + "Kérem üsse be a választott opció sorszámát!");
            valasztas = sc.nextLine();
            switch (valasztas) {
                case "1":
                    o1.getUgyfelList().get(0).newRent();
                    break;
                case "2":
                    o1.getUgyfelList().get(0).editRent();
                    break;
                case "3":
                    o1.getUgyfelList().get(0).searchCar();
                    break;
                case "4":
                    o1.getUgyfelList().get(0).complaint();
                    break;
                case "5":
                    System.out.println("Kérem adja meg a jelszavát!");
                    jelszo = sc.nextLine();
                    if (v.login(jelszo)) {
                        while (!valasz.equals("8")) {
                            System.out.println("Opciók:\n"
                                    + "1. Új autó hozzáadása\n"
                                    + "2. Autó törlése\n"
                                    + "3. Számlák kifizetése\n"
                                    + "4. Alkalmazottak kifizetése\n"
                                    + "5. Bevételek kezelése\n"
                                    + "6. Új alkalmazott felvétele\n"
                                    + "7. Alkalmazott elbocsátása\n"
                                    + "8. Visszalépés a főmenübe");
                            valasz = sc.nextLine();
                            switch (valasz) {
                                case "1":
                                    v.addCar();
                                    break;
                                case "2":
                                    v.removeCar();
                                    break;
                                case "3":
                                    v.costs();
                                    break;
                                case "4":
                                    v.salary();
                                    break;
                                case "5":
                                    int ev = 0;
                                    int honap = 0;
                                    boolean validEntry;
                                    do {
                                        try {
                                            System.out.println("Év:");
                                            Scanner scan = new Scanner(System.in);
                                            ev = scan.nextInt();
                                            validEntry = true;
                                        } catch (InputMismatchException e) {
                                            validEntry = false;
                                            System.out.println("Kérem egész számot üssön be!");
                                        }
                                    } while (!validEntry);
                                    do {
                                        try {
                                            System.out.println("Hónap:");
                                            Scanner scan = new Scanner(System.in);
                                            honap = scan.nextInt();
                                            if(honap > 0 && honap < 13)
                                                validEntry = true;
                                            else{
                                                validEntry = false;
                                                System.out.println("Kérem 1 és 12 közötti számot adjon meg!");
                                            }
                                        } catch (InputMismatchException e) {
                                            validEntry = false;
                                            System.out.println("Kérem egész számot üssön be!");
                                        }
                                    } while (!validEntry);
                                    v.income(ev, honap);
                                    break;
                                case "6":
                                    v.addEmployee();
                                    break;
                                case "7":
                                    v.removeEmployee();
                                    break;
                                case "8":
                                    System.out.println("Sikeresen kilépett.");
                                    break;
                                default:
                                    System.out.println("Nincs ilyen opció.");
                                    break;
                            }
                        }
                    } else {
                        System.out.println("Hibás jelszó!");
                    }
                    break;
                case "6":
                    System.out.println("Kérem adja meg a jelszavát!");
                    jelszo = sc.nextLine();
                    if (a.login(jelszo)) {
                        while (!valasz.equals("2")) {
                            System.out.println("Opciók:\n"
                                    + "1. Bérlések kilistázása\n"
                                    + "2. Kilépés");
                            valasz = sc.nextLine();
                            switch(valasz){
                                case "1":
                                    a.listRents();
                                case "2":
                                    System.out.println("Sikeresen kilépett.");
                                    break;
                                default:
                                    System.out.println("Nincs ilyen opció.");
                                    break;
                            }
                        }
                    }
                    else {
                        System.out.println("Hibás jelszó!");
                    }
                    break;
                case "7":
                    o1.getUgyfelList().get(0).contact();
                    break;
                case "8":
                    System.out.println("Sikeresen kilépett.");
                    break;
                default:
                    System.out.println("Nincs ilyen opció. Kérem próbálja újra!\n"
                            + "Ellenőrizze, hogy a helyes számot ütötte-e be! Példa: 1");
                    break;
            }
        }

    }
}
