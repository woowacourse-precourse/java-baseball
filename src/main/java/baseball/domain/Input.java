package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private final static String  REQUEST_PLAYER_GUESS = "숫자를 입력해주세요 : ";
    private final static int COMMON_GUESS_LENGTH = 3;
    private final static char MIN_GUESS_NUMBER = '1';
    private final static char MAX_GUESS_NUMBER = '9';
    private String playerGuess;

    public void getPlayerGuess() {
        System.out.print(REQUEST_PLAYER_GUESS);
        playerGuess = Console.readLine();
    }

    private void validateGuess() {
        if (playerGuess.length() != COMMON_GUESS_LENGTH) {
            throw new IllegalArgumentException("올바른 형식으로 입력해주세요.");
        }

        for (char guessNumber : playerGuess.toCharArray()) {
            if (guessNumber < MIN_GUESS_NUMBER || guessNumber > MAX_GUESS_NUMBER) {
                throw new IllegalArgumentException("올바른 형식으로 입력해주세요");
            }
        }

    }
}
