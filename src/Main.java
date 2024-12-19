public class Main {

    public Main() {
        Kalender kalender = new Kalender();
        Recensioner recensioner = new Recensioner();

        Facade fasad = new Facade(kalender, recensioner);
        visaMeny();
        int val = Input.läsMenyVal(4);

        switch (val) {
            case 3:
                fasad.recensionsMeny();
                break;
            case 4:
                fasad.kalenderMeny();
                break;
            default:
                throw new IllegalArgumentException();
        }


    }

    private void visaMeny() {
        System.out.println("Välkommen till Julius Plants bokningssytem!");

        System.out.println("Skriv en siffra för att välja i menyn");
        System.out.println("1. Portfolion\n" +
                "2. Information\n" +
                "3. Recensioner\n" +
                "4. Boka/avboka tid\n");
    }

    public static void main(String[] args) {
        new Main();
    }
}
