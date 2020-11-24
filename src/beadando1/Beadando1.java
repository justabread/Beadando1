package beadando1;

public class Beadando1 {
    public static void main(String[] args) {
        Osztalykezelo o1 = new Osztalykezelo();
        o1.ugyfelRead();
        o1.jarmuRead();
        o1.berlesRead();
        
        for(Ugyfel ugyfelek : o1.getUgyfelList())
        {
            System.out.println(ugyfelek.ugyfelToString());
        }
        
        for(Jarmu jarmuvek : o1.getJarmuList())
        {
            System.out.println(jarmuvek.jarmuToString());
        }
        
        o1.getBerlesMap().entrySet().forEach(currentBerles->{
            System.out.println(currentBerles.getKey() + "; " + currentBerles.getValue().berlesToString());
        });
        
        Vezeto v = new Vezeto();
        //v.addCar();
        //v.removeCar();
        o1.alkalmazottRead();
        for(Alkalmazott a : o1.getAlkalmazottList()){
            System.out.println(a.alkalmazottToString());
        }
        //v.addEmployee();
        //v.removeEmployee();
    }   
}
