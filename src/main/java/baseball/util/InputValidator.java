package baseball.util;

import java.util.HashSet;
import java.util.Set;

import static baseball.util.GameNumberGenerator.*;

public class InputValidator {
    public static final String RETRY_GAME = "1";
    public static final String EXIT_GAME = "2";

    public static void validatePlayerInputRetry(String playerInputRetry) throws IllegalArgumentException {
        if (!(playerInputRetry.equals(RETRY_GAME) || playerInputRetry.equals(EXIT_GAME))) {
            throw new IllegalArgumentException();
        }
    }

    public static void validatePlayerInputNumber(String playerInputNumber) throws IllegalArgumentException {
        Set<Character> cipherSet = makeCipherSet(playerInputNumber);
        if (playerInputNumber.length() != GAME_NUMBER_LENGTH || cipherSet.size() != GAME_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private static Set<Character> makeCipherSet(String playerInputNumber){
        Set<Character> cipherSet = new HashSet<>();
        for (int i = 0; i < playerInputNumber.length(); i++) {
            char cipher = playerInputNumber.charAt(i);
            if (!(cipher >= '1' && cipher <= '9')) {
                throw new IllegalArgumentException();
            }
            cipherSet.add(cipher);
        }
        return cipherSet;
    }
}
