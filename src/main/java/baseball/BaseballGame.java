package baseball;

import java.util.Random;

public class BaseballGame {
    BaseballGame() {
    }

    public int[] makeRandomNumber() {
        int[] result = new int[3];
        boolean[] alreadyUsed = new boolean[9];
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int number = random.nextInt(9) + 1;

            if (!alreadyUsed[number]) {
                alreadyUsed[number] = true;
                result[i] = number;
            } else {
                i--;
            }
        }
        return result;
    }
}
