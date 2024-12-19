import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Recensioner extends Sida {

    List<Object> recensioner;
    Filhanterare filhanterare;
    String filnamn = "recensioner.ser";

    public Recensioner() {
        recensioner = new ArrayList<>();
        filhanterare = new Filhanterare();
        filhanterare.läsFrånFil(recensioner, filnamn);


        System.out.println("Recensioner");
        System.out.println("Vill du läsa (1) eller skriva (2) recension?");
        int val = Input.läsMenyVal(2);
        if (val == 1) {
            läsRecension();
        } else if (val == 2) {
            skrivRecension();
        } else {
            throw new IllegalArgumentException();
        }
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

        filhanterare.skrivTillFil(recensioner, filnamn);
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
