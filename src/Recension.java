import java.io.Serializable;

public class Recension implements Serializable {

    private String namn;
    private String titel;
    private String text;

    public Recension(String namn, String titel, String text) {
        this.namn = namn;
        this.titel = titel;
        this.text = text;
    }

    public String getNamn() {
        return namn;
    }

    public String getTitel() {
        return titel;
    }

    public String getText() {
        return text;
    }
}