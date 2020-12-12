package beadando1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ugyfel {
    private final String name;
    private final int ugyfelId;

    public Ugyfel(int ugyfelId, String name) {
        this.name = name;
        this.ugyfelId = ugyfelId;
    }
    
    public int getUgyfelId()
    {
        return this.ugyfelId;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public void complaint(){
        System.out.println("Kérjük panaszát írja meg a panasz.kezeles@gmail.com e-mail címre.");
    }
    
    public void newRent(){}
    
    public void editRent(){}
    
    public void searchCar() {
        Osztalykezelo o = new Osztalykezelo();
        o.jarmuRead();
        System.out.println("Gyártók:\n");
        List<String> gyartoLista = new ArrayList<>();
        gyartoLista.add(o.getJarmuList().get(0).getBrand());
        for (Jarmu jarmuvek : o.getJarmuList()) {
            boolean voltMar = false;
            for(int k = 0; k < gyartoLista.size(); k++){
                if(gyartoLista.get(k).equals(jarmuvek.getBrand())){
                    voltMar = true;
                }
            }
            if(!voltMar){
                gyartoLista.add(jarmuvek.getBrand());
            }
        }
        for(String s : gyartoLista){
            System.out.println(s);
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Kérem válasszon gyártót!");
        String gyarto = sc.nextLine();
        while(!gyartoLista.contains(gyarto)){
            System.out.println("Nincs ilyen gyártó!");
            System.out.println("Kérem próbálja újra!");
            gyarto = sc.nextLine();
        }
        for (Jarmu jarmuvek : o.getJarmuList()) {
            if(gyarto.equals(jarmuvek.getBrand())){
                System.out.println(jarmuvek.jarmuToString());
            }
        }
    }
    
    public String ugyfelToString()
    {
        return this.ugyfelId + "; " + this.name;
    }  
}
