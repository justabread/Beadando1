package beadando1;

import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Osztalykezelo {
    private List<Jarmu> jarmuList;
    private Map<Integer, Berles> berlesMap;
    private List<Ugyfel> ugyfelList;      
    
    public Osztalykezelo()
    {
        this.jarmuList = new ArrayList<>();
        this.berlesMap = new LinkedHashMap<>();
        this.ugyfelList = new ArrayList<>();
    }
    
      public List<Ugyfel> getUgyfelList()
    {
        return ugyfelList;
    }
    
    public List<Jarmu> getJarmuList()
    {
        return jarmuList;
    }
    
    public Map<Integer, Berles> getBerlesMap()
    {
        return berlesMap;
    }
    
    public void ugyfelRead()
    {
        try{
            File ugyfelFile = new File("ugyfelFile.txt");
            Scanner ugyfelReader = new Scanner(ugyfelFile);
            while(ugyfelReader.hasNextLine())
            {
                String currentLine = ugyfelReader.nextLine();
                String[] lineData = currentLine.split(";");
                Ugyfel currentUgyfel = new Ugyfel(Integer.parseInt(lineData[0]), lineData[1]);
                
                ugyfelList.add(currentUgyfel);
            }
        }catch(FileNotFoundException e)
        {
            System.out.println("Error: ugyfelFile.txt not found");
        }    
    }
    
    public void jarmuRead()
    {
        try{
            File jarmuFile = new File("jarmuFile.txt");
            Scanner jarmuReader = new Scanner(jarmuFile);
            while(jarmuReader.hasNextLine())
            {
                String currentLine = jarmuReader.nextLine();
                String[] lineData = currentLine.split(";");
                Jarmu currentJarmu = new Jarmu(lineData[0], lineData[1], lineData[2], Integer.parseInt(lineData[3]));

                jarmuList.add(currentJarmu);
            }
        }catch(FileNotFoundException e)
        {
            System.out.println("Error: jarmuFile.txt not found");
        }    
    }
    
    public void berlesRead()
    {
        DateTimeFormatter berlesFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        List<String> currentVehicles=new ArrayList<String>();
        int totalPrice = 0;
        long berlesDays = 0;
        
        try{
            File berlesFile = new File("berlesFile.txt");
            Scanner berlesReader = new Scanner(berlesFile);
            while(berlesReader.hasNextLine())
            {
                String currentLine = berlesReader.nextLine();
                String[] lineData = currentLine.split(";");
                LocalDate startDate = LocalDate.parse(lineData[1], berlesFormat);
                LocalDate endDate = LocalDate.parse(lineData[2], berlesFormat);
                
                for(int i = 3; i < lineData.length; i++)
                {
                    System.out.println(lineData[i]);
                    //currentVehicles.add("pp");
                    /*for(Jarmu jarmuvek : jarmuList) 
                    {
                        if(jarmuvek.getLicense().equalsIgnoreCase(lineData[i])) 
                        {
                            totalPrice += jarmuvek.getPrice();
                        }
                    }*/
                }
                
                berlesDays = Duration.between(startDate.atStartOfDay(), endDate.atStartOfDay()).toDays();
                totalPrice *= berlesDays; 
                
                Berles currentBerles = new Berles(totalPrice, startDate, endDate, currentVehicles);
                berlesMap.put(Integer.parseInt(lineData[0]), currentBerles);
                
            }                       
        }catch(FileNotFoundException e)
        {
            System.out.println("Error: berlesFile.txt not found");
        }   
    }
}
