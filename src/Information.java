// Regler och villkor, prislista samt kontaktuppgifter till Julius
public class Information extends Sida {

    String reglerOchVillkor = "Regler och villkor: \n- Avbokning eller ändring av datum måste ske minst 5 dagar innan den bokade tiden." +
            "\n- Om du blir mer än 20 minuter sen debiteras du en extra kostnad. \n- Betalning sker endast via faktura.";
    String prislista = "Priser: \n- Bröllop 7000 kr \n- Dop: 5000 kr";
    String kontaktuppgifter = "Kontakt: \nVid frågor och funderingar kontakta mig på 070088664 eller julius.plant@gmail.se";


    public Information() {
        System.out.println("Information\n"  + reglerOchVillkor + "\n" + prislista + "\n" + kontaktuppgifter);
    }

}
