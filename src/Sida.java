import java.util.Scanner;

public abstract class Sida {

    void gåTillMeny(){
        System.out.println("Vill du: \n1. Gå tillbaka till menyn\n2. Avsluta");
        int val = Input.läsMenyVal(2);
        if (val == 1) {
            //gå till menyn
        } else if (val == 2) {
            System.exit(0);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
