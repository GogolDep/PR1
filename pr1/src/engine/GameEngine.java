package engine;

import java.util.Scanner;

public class GameEngine {
    private static final int ROUNDS_COUNT = 3;

    public static void run(String gameRules, GameProvider gameProvider) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
        System.out.println(gameRules);

        for (int i = 0; i < ROUNDS_COUNT; i++) {
            String[] roundData = gameProvider.generateRound();
            System.out.println("Question: " + roundData[0]);
            System.out.print("Your answer: ");
            String answer = scanner.nextLine();

            if (!answer.equals(roundData[1])) {
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%n",
                        answer, roundData[1]);
                System.out.println("Let's try again, " + name + "!");
                scanner.close();
                return;
            }
            System.out.println("Correct!");
        }

        System.out.println("Congratulations, " + name + "!");
        scanner.close();
    }
}