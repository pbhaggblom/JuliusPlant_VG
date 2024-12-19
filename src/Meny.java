public class Meny {

    SidFactory factory = new SidFactory();

    public Meny() {

        while (true) {
            visaMeny();
            int input = Input.läsMenyVal(4);
            try {
                Sida sida = factory.visaSida(input);
                sida.gåTillMeny();
            } catch (IllegalArgumentException e) {
                System.out.println("Felaktigt argument i Input.läsMenyVal()");
            }
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
        new Meny();
    }
}