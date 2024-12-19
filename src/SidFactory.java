public class SidFactory {

    public Sida visaSida(int input) {
        switch (input) {
            case 1:
                return new Portfolio();
            case 2:
                return new Information();
            case 3:
                return new Recensioner();
            case 4:
                return new Kalender();
            default:
                throw new IllegalArgumentException();
        }
    }
}