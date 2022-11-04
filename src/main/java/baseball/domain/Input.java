package baseball.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;

public class Input {
    private final static String  REQUEST_PLAYER_GUESS = "숫자를 입력해주세요 : ";
    private final static String REQUEST_PLAYER_CHOICE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final static int COMMON_GUESS_LENGTH = 3;
    private final static char MIN_GUESS_NUMBER = '1';
    private final static char MAX_GUESS_NUMBER = '9';
    private String playerGuess;
    private String playerChoice;

    public void getPlayerGuess() {
        System.out.print(REQUEST_PLAYER_GUESS);
        playerGuess = Console.readLine();
        validateGuess();
    }

    private boolean guessAreNotUniqueNumbers() {
        HashSet<Character> guessNumbers = new HashSet<>();

        for (char guessNumber : playerGuess.toCharArray()) {
            if (guessNumbers.contains(guessNumber) || guessNumber < MIN_GUESS_NUMBER || guessNumber > MAX_GUESS_NUMBER) {
                return true;
            }
            guessNumbers.add(guessNumber);
        }

        return false;
    }

    private void validateGuess() {
        if (playerGuess.length() != COMMON_GUESS_LENGTH || guessAreNotUniqueNumbers()) {
            throw new IllegalArgumentException("올바른 형식으로 입력해주세요.");
        }
    }

    public void readPlayerChoice() {
        System.out.println(REQUEST_PLAYER_CHOICE);
        playerChoice = Console.readLine();
        validateChoice();
    }

    private void validateChoice() {
        if (playerChoice.length() != 1) {
            throw new IllegalArgumentException("올바른 형식으로 입력해주세요.");
        }
        if (!playerChoice.equals("1") && !playerChoice.equals("2")) {
            throw new IllegalArgumentException("올바른 형식으로 입력해주세요.");
        }
    }
}
