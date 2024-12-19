public class Facade {

    Kalender kalender;
    Recensioner recensioner;

    public Facade(Kalender kalender, Recensioner recensioner) {
        this.kalender = kalender;
        this.recensioner = recensioner;
    }

    public void recensionsMeny() {
        recensioner.läsInRecensioner();
        int val = recensioner.meny();
        if (val == 1) {
            recensioner.läsRecension();
        } else if (val == 2) {
            recensioner.skrivRecension();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void kalenderMeny() {
        kalender.läsInBokningar();
        int val = kalender.meny();
        if (val == 1) {
            kalender.boka();
        } else if (val == 2) {
            kalender.avboka();
        } else {
            throw new IllegalArgumentException();
        }
    }


}
