import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Recensioner extends Sida {

    ArrayList<Object> recensioner;
    FilManager manager;
    String filnamn = "recensioner.ser";

    public Recensioner() {
        manager = FilManager.INSTANCE;
    }

    public int meny() {
        System.out.println("Vill du:\n1. Läsa recensioner\n2. Skriva recension");
        int val = Input.läsMenyVal(2);
        return val;
    }

    public void läsInRecensioner() {
        recensioner = manager.läsFrånFil(filnamn);
    }

    public void skrivRecension() {
        String namn = Input.läsAnvändarInput("Skriv ert namn: ");
        String titel = Input.läsAnvändarInput("Skriv titel: ");
        String recension = Input.läsAnvändarInput("Skriv recension: ");

        Recension r = new Recension(namn, titel, recension);
        recensioner.add(r);

        manager.skrivTillFil(filnamn, recensioner);
    }

    public void läsRecension() {
        for (Object o : recensioner) {
            if (o instanceof Recension) {
                Recension r = (Recension) o;
                System.out.println("Namn: " + r.getNamn());
                System.out.println("Titel: " + r.getTitel());
                System.out.println("Recension: " + r.getText());
                System.out.println(".....................................");
            }
        }
    }
}
