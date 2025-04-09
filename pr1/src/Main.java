import games.LCMGame;
import games.ProgressionGame;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a game:");
        System.out.println("1 - Least Common Multiple");
        System.out.println("2 - Geometric Progression");
        System.out.print("Your choice: ");

        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                LCMGame.play();
                break;
            case "2":
                ProgressionGame.play();
                break;
            default:
                System.out.println("Invalid choice!");
        }

        scanner.close();
    }
}