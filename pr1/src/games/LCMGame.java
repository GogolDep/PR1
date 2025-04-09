package games;

import engine.GameEngine;
import engine.GameProvider;
import java.util.Random;

public class LCMGame {
    private static final String RULES = "Find the smallest common multiple of given numbers.";
    private static final Random RANDOM = new Random();

    public static void play() {
        GameEngine.run(RULES, LCMGame::generateRound);
    }

    private static String[] generateRound() {
        int a = RANDOM.nextInt(10) + 1;
        int b = RANDOM.nextInt(10) + 1;
        int c = RANDOM.nextInt(10) + 1;

        int lcm = calculateLCM(a, b, c);
        return new String[] {
                a + " " + b + " " + c,
                String.valueOf(lcm)
        };
    }

    private static int calculateLCM(int a, int b, int c) {
        return calculateLCM(calculateLCM(a, b), c);
    }

    private static int calculateLCM(int a, int b) {
        return a * b / calculateGCD(a, b);
    }

    private static int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}