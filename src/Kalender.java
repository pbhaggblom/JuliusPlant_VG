import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kalender extends Sida {

    ArrayList<Object> bokningar;
    List<LocalDate> ledigaTider;
    FilManager manager;
    String filnamn = "bokningar.ser";

    public Kalender() {
        manager = FilManager.INSTANCE;
    }

    public int meny() {
        System.out.println("Vill du: \n1. Boka\n2. Avboka");
        int val = Input.läsMenyVal(2);
        return val;
    }

    public void läsInBokningar() {
        bokningar = manager.läsFrånFil(filnamn);
    }

    public void hittaLedigaTider() {
        ledigaTider = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            LocalDate datum = LocalDate.now().plusDays(i);
            boolean datumHittades = false;
            for (Object bokning : bokningar) {
                Bokning b = (Bokning) bokning;
                if (b.getDatum().equals(datum)) {
                    datumHittades = true;
                    break;
                }
            }
            if (!datumHittades) {
                ledigaTider.add(datum);
            }
        }
    }

    public void boka() {
        for (int i = 0; i < ledigaTider.size(); i++) {
            System.out.println((i + 1) + ": "+ ledigaTider.get(i));
        }
        System.out.println("Välj ett datum:");
        int val = Input.läsMenyVal(ledigaTider.size());
        LocalDate datum = ledigaTider.get(val - 1);

        String namn = Input.läsAnvändarInput("Ange ditt namn: ");
        String mail = Input.läsAnvändarInput("Ange din mailadress: ");

        bokningar.add(new Bokning(datum, namn, mail));
        manager.skrivTillFil(filnamn, bokningar);
        System.out.println("Följande bokning registrerades:\nDatum: " + datum + "\nNamn: " + namn + "\nMail: " + mail);
    }

    public void avboka() {
        String mail = Input.läsAnvändarInput("Ange din mailadress: ");
        boolean bokningHittades = false;
        for (int i = 0; i < bokningar.size(); i++) {
            Bokning b = (Bokning) bokningar.get(i);
            if (b.getMail().equals(mail)) {
                System.out.println("Din bokning " + b.getDatum() + " är avbokad");
                bokningar.remove(i);
                bokningHittades = true;
            }
        }
        if (!bokningHittades) {
            System.out.println("Hittade ingen bokning med angiven mailadress");
        }

        manager.skrivTillFil(filnamn, bokningar);
    }
}