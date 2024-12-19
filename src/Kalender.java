import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kalender extends Sida {

    List<Object> bokningar;
    Filhanterare filhanterare;
    String filnamn = "bokningar.ser";


    public Kalender() {
        bokningar = new ArrayList<>();
        filhanterare = new Filhanterare();
        filhanterare.läsFrånFil(bokningar, filnamn);

        System.out.println("Vill du: \n1. Boka\n2. Avboka");
        int val = Input.läsMenyVal(2);
        if (val == 1) {
            boka();
        } else if (val == 2) {
            avboka();
        } else {
            throw new IllegalArgumentException();
        }

    }

    public void boka() {
        List<LocalDate> ledigaTider = new ArrayList<>();
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
        for (int i = 0; i < ledigaTider.size(); i++) {
            System.out.println((i + 1) + ": "+ ledigaTider.get(i));
        }

        System.out.println("Välj ett datum:");
        Scanner scan = new Scanner(System.in);

        int val = Input.läsMenyVal(ledigaTider.size() - 1);
        LocalDate datum = ledigaTider.get(val - 1);

        System.out.print("Ange ditt namn: ");
        String namn = scan.nextLine();

        System.out.print("Ange din mailadress: ");
        String mail = scan.nextLine();

        bokningar.add(new Bokning(datum, namn, mail));
        filhanterare.skrivTillFil(bokningar, filnamn);

        System.out.println("Följande bokning registrerades:\nDatum: " + datum + "\nNamn: " + namn + "\nMail: " + mail);
    }

    public void avboka() {
        System.out.println("Ange din mailadress: ");
        Scanner scan = new Scanner(System.in);
        String mail = scan.nextLine();
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
        filhanterare.skrivTillFil(bokningar, filnamn);
    }
}