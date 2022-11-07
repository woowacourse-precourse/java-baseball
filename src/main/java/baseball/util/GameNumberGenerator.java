package baseball.util;

import static camp.nextstep.edu.missionutils.Randoms.*;

public final class GameNumberGenerator {
    public static final int GAME_NUMBER_LENGTH = 3;
    public static final int GAME_NUMBER_MIN = 1;
    public static final int GAME_NUMBER_MAX = 9;

    public static String createGameNumber() {
        String gameNumber = "";
        boolean used[] = new boolean[GAME_NUMBER_MAX + 1];
        for (int i = 0; i < GAME_NUMBER_LENGTH; i++) {
            int randomNumber = getNotDuplicatedNumber(used);
            gameNumber += String.valueOf(randomNumber);
        }
        return gameNumber;
    }

    public static int getNotDuplicatedNumber(boolean[] used) {
        int randomNumber = pickNumberInRange(GAME_NUMBER_MIN, GAME_NUMBER_MAX);
        while (used[randomNumber] == true) {
            randomNumber = pickNumberInRange(GAME_NUMBER_MIN, GAME_NUMBER_MAX);
        }
        used[randomNumber] = true;
        return randomNumber;
    }
}