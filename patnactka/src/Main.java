import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Layout l = new Layout();
        boolean konec = true;
        do {
            try {
                System.out.println("Your gaming layout:");
                System.out.println(l.drawLayout());
                System.out.println("Which number do you want to move:");
                l.swapNumber(sc.nextInt());
                if (l.check()) {
                    konec = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Just whole numbers between 1 and 15");
                sc.nextLine();
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Something is wrong");
                sc.nextLine();
            }
        }while (konec) ;

        System.out.println("\n" +
                "██╗░░░██╗░█████╗░██╗░░░██╗  ░██╗░░░░░░░██╗██╗███╗░░██╗\n" +
                "╚██╗░██╔╝██╔══██╗██║░░░██║  ░██║░░██╗░░██║██║████╗░██║\n" +
                "░╚████╔╝░██║░░██║██║░░░██║  ░╚██╗████╗██╔╝██║██╔██╗██║\n" +
                "░░╚██╔╝░░██║░░██║██║░░░██║  ░░████╔═████║░██║██║╚████║\n" +
                "░░░██║░░░╚█████╔╝╚██████╔╝  ░░╚██╔╝░╚██╔╝░██║██║░╚███║\n" +
                "░░░╚═╝░░░░╚════╝░░╚═════╝░  ░░░╚═╝░░░╚═╝░░╚═╝╚═╝░░╚══╝");
    }
}