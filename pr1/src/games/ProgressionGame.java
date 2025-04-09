package games;

import engine.GameEngine;
import engine.GameProvider;
import java.util.Random;

public class ProgressionGame {
    private static final String RULES = "What number is missing in the progression?";
    private static final Random RANDOM = new Random();
    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH = 10;

    public static void play() {
        GameEngine.run(RULES, ProgressionGame::generateRound);
    }

    private static String[] generateRound() {
        int length = MIN_LENGTH + RANDOM.nextInt(MAX_LENGTH - MIN_LENGTH + 1);
        int start = RANDOM.nextInt(10) + 1;
        int step = RANDOM.nextInt(5) + 1;
        int hiddenPos = RANDOM.nextInt(length);

        StringBuilder question = new StringBuilder();
        int hiddenNumber = 0;

        for (int i = 0; i < length; i++) {
            int current = start * (int) Math.pow(step, i);
            if (i == hiddenPos) {
                question.append(".. ");
                hiddenNumber = current;
            } else {
                question.append(current).append(" ");
            }
        }

        return new String[] {
                question.toString().trim(),
                String.valueOf(hiddenNumber)
        };
    }
}