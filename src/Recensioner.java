import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Recensioner extends Sida {

    ArrayList<Object> recensioner;
    FilManager manager;
    String filnamn = "recensioner.ser";

    public Recensioner() {
        recensioner = new ArrayList<>();

        manager = FilManager.INSTANCE;


    }

    public int meny() {
        System.out.println("Vill du läsa (1) eller skriva (2) recension?");
        int val = Input.läsMenyVal(2);
        return val;
    }

    public void läsInRecensioner() {
        recensioner = manager.läsFrånFil(filnamn);
    }

    public void skrivRecension() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Skriv ert namn: ");
        String namn = scanner.nextLine();

        System.out.println("Skriv titel: ");
        String titel = scanner.nextLine();

        System.out.println("Skriv recension: ");
        String recension = scanner.nextLine();

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
