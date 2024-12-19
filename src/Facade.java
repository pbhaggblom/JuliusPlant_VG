public class Facade {

    Portfolio portfolio;
    Information information;
    Kalender kalender;
    Recensioner recensioner;

    public Facade(Portfolio portfolio, Information information, Kalender kalender, Recensioner recensioner) {
        this.portfolio = portfolio;
        this.information = information;
        this.kalender = kalender;
        this.recensioner = recensioner;
    }

    public void visaPortfolio() {
        portfolio.skrivUtPortfolio();
        portfolio.gåTillMeny();
    }

    public void visaInformation() {
        information.skrivUtInformation();
        information.gåTillMeny();
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
        recensioner.gåTillMeny();
    }

    public void kalenderMeny() {
        kalender.läsInBokningar();
        int val = kalender.meny();
        kalender.hittaLedigaTider();
        if (val == 1) {
            kalender.boka();
        } else if (val == 2) {
            kalender.avboka();
        } else if (val == 3) {
            kalender.omboka();
        } else {
            throw new IllegalArgumentException();
        }
        kalender.gåTillMeny();
    }
}
