import javax.sound.sampled.Port;

public class Main {

    public Main() {
        Portfolio portfolio = new Portfolio();
        Information information = new Information();
        Kalender kalender = new Kalender();
        Recensioner recensioner = new Recensioner();

        Facade fasad = new Facade(portfolio, information, kalender, recensioner);

        while (true) {
            visaMeny();
            int val = Input.läsMenyVal(5);

            switch (val) {
                case 1:
                    fasad.visaPortfolio();
                    break;
                case 2:
                    fasad.visaInformation();
                    break;
                case 3:
                    fasad.recensionsMeny();
                    break;
                case 4:
                    fasad.kalenderMeny();
                    break;
                case 5:
                    System.exit(0);
                default:
                    throw new IllegalArgumentException();
            }
        }
    }

    private void visaMeny() {
        System.out.println("Välkommen till Julius Plants bokningssytem!");

        System.out.println("Skriv en siffra för att välja i menyn");
        System.out.println("1. Portfolion\n" +
                "2. Information\n" +
                "3. Recensioner\n" +
                "4. Boka/avboka tid\n" +
                "5. Avsluta");
    }

    public static void main(String[] args) {
        new Main();
    }
}
