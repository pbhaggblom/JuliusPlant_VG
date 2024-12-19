import java.io.Serializable;
import java.time.LocalDate;

public class Bokning implements Serializable {

    private LocalDate datum;
    private String namn;
    private String mail;

    public Bokning(LocalDate datum, String namn, String mail) {
        this.datum = datum;
        this.namn = namn;
        this.mail = mail;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public String getMail() {
        return mail;
    }
}