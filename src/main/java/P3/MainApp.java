package P3;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static List<Mobilier> citire(){
        try {
            File file = new File("src/main/resources/mobilier.json");
            ObjectMapper mapper = new ObjectMapper();
            //mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES); //asta ii pentru ca nu poate citi clasa placa (placa: [) ca asteapta un String da tu ii dai un array
            //!!! nu trebe neaparat aia ca am scris descriere gresit
            List<Mobilier> mob = mapper.readValue(file, new TypeReference<List<Mobilier>>() {
            });
            return mob;
        }catch (IOException e){
            System.err.println("Fisier gol!!" + e.getMessage());
            //return null;
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Mobilier> mob = null;
        int opt;

        do {
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("1.Citește datele despre piesele de mobilier din fișierul mobilier.json într-o listă de piese de mobilier (List<Mobilier>) și le afișează");
            System.out.println("2.Afişează elementele de mobilier din colecție şi plăcile care le compun");
            System.out.println("3.Afişează caracteristicile plăcilor care compun o anumită piesă de mobilier");
            System.out.println("4.Afișează estimativ numărul colilor de pal necesare pentru realizarea unui anumit corp de mobile știind că o coală de pal are dimensiunea 2800 x 2070 mm");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");

            System.out.print("Introduceti optiunea dorita: ");
            opt = scanner.nextInt();

            switch (opt) {
                case 1:
                    mob = citire();
                    System.out.println("Datele au fost citite cu success!!");
                    for (Mobilier m : mob) {
                        System.out.println(m);
                    }
                    break;
                case 2:
                    afisareCerinta2(mob);
                    break;
                case 3:
                    afisareCerinta3(mob);
                    break;
                case 4:
                    afisareNrColiNecesare(mob);
                    break;
                default:
                    break;
            }
        } while (true);
    }

    public static void afisareCerinta2(List<Mobilier> mob){
        if (mob != null) {
            for(Mobilier m: mob){
                System.out.println("Numele obiectului de mobilier: " + m.getNume());
                System.out.println("Placile care il compun:");
                for(Placa p: m.getPlaci()){
                    System.out.println(p);
                }
            }
            System.out.println();
        }
        else{
            System.out.println("Vezi ca lista e goala!!!");
        }
    }

    public static void afisareCerinta3(List<Mobilier> mob){
        if(mob != null){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Introduceti numele mobilierului despre care doriti sa aflati informatii: ");
            String numePiesa = scanner.nextLine();
            for(Mobilier m: mob){
                if(m.getNume().equals(numePiesa)){
                    System.out.println("Numele obiectului de mobilier: " + m.getNume());
                    for(Placa p: m.getPlaci()){
                        System.out.println(p.getDescriere());
                    }
                    return;
                }
            }
            System.out.println("Mobilierul cu numele " + numePiesa + " nu a fost gasit");
        }else{
            System.out.println("Lista goala!!");
        }
    }

    public static void afisareNrColiNecesare(List<Mobilier> mob){
        if(mob != null){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduceti numele piesei de mobilier pentru care doresti sa calculezi numarul de coli necesare: ");
            String numeDeCautat = scanner.nextLine();

            for(Mobilier m : mob){
                if(m.getNume().equals(numeDeCautat)){
                    int nrDeColiNecesare = numarColiNecesare(m);
                    System.out.println("Pentru aceasta piesa de mobilier, numarul estimativ de coli necesare este " + nrDeColiNecesare);
                    return;
                }
            }
            System.out.println("Obiectul de mobilier " + numeDeCautat + " nu a fost gasit!!");
        }else{
            System.out.println("Lista e goala!!");
        }
    }
    public static int numarColiNecesare(Mobilier mob){ //WTF fara lista la parametru
        int lungimeCoalaPal = 2800;
        int latimeCoalaPal = 2070;

        int nrColiNecesare = 0;
        for(Placa p: mob.getPlaci()){
            int lungimePlace = p.getLungime();
            int latimePlace = p.getLatime();
            int nrBucatiPlaci = p.getNr_bucati();

            int ariePlaca = lungimePlace * latimePlace * nrBucatiPlaci;
            int arieColi = lungimeCoalaPal * latimeCoalaPal;

            nrColiNecesare += ariePlaca / arieColi;
        }
        return nrColiNecesare;
    }
}
