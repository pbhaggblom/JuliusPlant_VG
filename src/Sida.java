import java.util.Scanner;

public abstract class Sida {

    void gåTillMeny(){
        System.out.println("Vill du gå tillbaka till menyn? [j/n]");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        if (input.equals("j")) {
            //gå tillbaka till meny
        } else if (input.equals("n")) {
            System.exit(0);
        }
    }
}
