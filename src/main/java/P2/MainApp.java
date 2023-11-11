package P2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MainApp {

    public static void scriere(List<PerecheNumere> pereche) {
        try{
            File file = new File("src/main/resources/PerecheNumere.json");
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(file,pereche);
        }catch(IOException e){
            System.err.println("Fisier gol!!" + e.getMessage());
        }
    }

    static List<PerecheNumere> citire(){
        try{
            File file = new File("src/main/resources/PerecheNumere.json");
            ObjectMapper mapper = new ObjectMapper();
            List<PerecheNumere> per = mapper.readValue(file, new TypeReference<List<PerecheNumere>>() {
            });
            return per;
        }catch(IOException e){
            System.err.println("FisierCox!!" + e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {

        List<PerecheNumere> per = citire();
        for(PerecheNumere p: per){
            if(p.Fibonacci())
            {
                System.out.println(p);
            }
        }
        System.out.print("\n");

        for(PerecheNumere p: per){
            System.out.print(p.cmmmc() + " ");
        }
        System.out.print("\n");

        for(PerecheNumere p:per){
            if(p.sumaCifreEgala()){
                System.out.println(p);
            }
        }
        System.out.print("\n");

        for(PerecheNumere p: per){
            if(p.validareCifrePare()){
                System.out.println(p);
            }
        }
    }
}
