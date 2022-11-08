package baseball.utils;

import java.util.Random;

public abstract class RandomGenerator {
    private static final Random random = new Random();
    private static final int MAX_BOUND = 9;

    public static int generateRandomNumber() {
        return random.nextInt(MAX_BOUND) + 1;
    }
}
