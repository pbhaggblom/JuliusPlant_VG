import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Kalender extends Sida {

    ArrayList<Bokning> bokningar;
    List<LocalDate> ledigaTider;
    FilManager manager;
    String filnamn = "bokningar.ser";

    public Kalender() {
        manager = FilManager.INSTANCE;
    }

    public int meny() {
        System.out.println("Vill du: \n1. Boka\n2. Avboka\n3. Omboka\n4. Visa bokade tider (administratör)");
        return Input.läsMenyVal(4);
    }

    public void läsInBokningar() {
        bokningar = manager.läsFrånFil(filnamn);
    }

    public void hittaLedigaTider() {
        ledigaTider = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            LocalDate datum = LocalDate.now().plusDays(i);
            boolean datumHittades = false;
            for (Bokning b : bokningar) {
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
        LocalDate datum = väljLedigTid();

        String namn = Input.läsAnvändarInput("Ange ditt namn: ");
        String mail = Input.läsAnvändarInput("Ange din mailadress: ");

        bokningar.add(new Bokning(datum, namn, mail));
        manager.skrivTillFil(filnamn, bokningar);
        System.out.println("Följande bokning registrerades:\nDatum: " + datum + "\nNamn: " + namn + "\nMail: " + mail);
    }

    public void avboka() {
        String mail = Input.läsAnvändarInput("Ange din mailadress: ");
        int index = hittaBokning(mail);
        if (index == -1) {
            return;
        }
        System.out.println("Din bokning " + bokningar.get(index).getDatum() + " avbokades.");
        bokningar.remove(index);
        manager.skrivTillFil(filnamn, bokningar);
    }

    public void omboka() {
        String mail = Input.läsAnvändarInput("Ange din mailadress: ");
        int index = hittaBokning(mail);
        if (index == -1) {
            return;
        }
        String namn = bokningar.get(index).getNamn();
        LocalDate avbokadTid = bokningar.get(index).getDatum();
        bokningar.remove(index);
        LocalDate datum = väljLedigTid();
        bokningar.add(new Bokning(datum, namn, mail));
        System.out.println("Du ändrade din bokning från " + avbokadTid + " till " + datum);
        manager.skrivTillFil(filnamn, bokningar);
    }

    public int hittaBokning(String mail) {
        ArrayList<Integer> existerandeBokningar = new ArrayList<>();
        int index = -1;
        for (int i = 0; i < bokningar.size(); i++) {
            Bokning b = bokningar.get(i);
            if (b.getMail().equals(mail)) {
                existerandeBokningar.add(i);
            }
        }
        if (existerandeBokningar.isEmpty()) {
            System.out.println("Hittade inga bokningar");
        } else if (existerandeBokningar.size() > 1) {
            int b = väljBokning(existerandeBokningar);
            return existerandeBokningar.get(b - 1);
        } else {
            return existerandeBokningar.getFirst();
        }
        return index;
    }

    public int väljBokning(ArrayList<Integer> lista) {
        System.out.println("Vilken bokning avser ärendet?");
        for (int i = 0; i < lista.size(); i++) {
            int index = lista.get(i);
            System.out.println((i + 1) + ": "+ bokningar.get(index).getDatum());
        }
        return Input.läsMenyVal(lista.size());
    }

    public LocalDate väljLedigTid() {
        for (int i = 0; i < ledigaTider.size(); i++) {
            System.out.println((i + 1) + ": "+ ledigaTider.get(i));
        }
        System.out.println("Välj ett datum:");
        int val = Input.läsMenyVal(ledigaTider.size());
        return ledigaTider.get(val - 1);
    }

    public void visaBokadeTider() {
        String lösenord = Input.läsAnvändarInput("Ange lösenord:");
        if (!lösenord.equals("admin")) {
            System.out.println("Du har inte behörighet att visa den här sidan");
            return;
        }
        System.out.println("Bokningar: ");
        for (int i = 0; i < bokningar.size(); i++) {
            System.out.println("Datum: " + bokningar.get(i).getDatum() +
                    "\nNamn: " + bokningar.get(i).getNamn() +
                    "\nMail: " + bokningar.get(i).getMail() +
                    "\n...................");
        }
    }
}