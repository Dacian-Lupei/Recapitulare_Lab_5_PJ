package P1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MainApp {
    public static void scriere(List<Persoana> lista) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("src/main/resources/persoane.json");
            mapper.writeValue(file,lista);
        }catch(IOException e){
            System.err.println("Fisier gol!!" + e.getMessage());
        }
    }

    public static List<Persoana> citire(){
        try{
            File file = new File("src/main/resources/persoane.json");
            ObjectMapper mapper = new ObjectMapper();
            List<Persoana> pers = mapper.readValue(file, new TypeReference<List<Persoana>>(){});
            return pers;
        }catch (IOException e){
            System.err.println("FisierCox!!" + e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        List<Persoana> pers = citire();
        System.out.println(pers);

        for(Persoana p: pers){
            System.out.println(p);
        }
        pers.add(new Persoana("Maria",33));
        scriere(pers);
    }
}
