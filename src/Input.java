import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {

    public static int läsMenyVal(int antalVal) {
        Scanner scan = new Scanner(System.in);
        int val = 0;
        try {
            val = scan.nextInt();
            if (val < 1 || val > antalVal) {
                System.out.println("Välj en siffra som motsvarar något av alternativen");
                val = läsMenyVal(antalVal);
            }
        } catch (InputMismatchException e) {
            System.out.println("Välj en siffra som motsvarar något av alternativen");
            val = läsMenyVal(antalVal);
        }
        return val;
    }
}
