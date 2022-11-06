package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;

public class Input {
    private final static String  REQUEST_PLAYER_GUESS = "숫자를 입력해주세요 : ";
    private final static String REQUEST_PLAYER_CHOICE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final static String RESTART_OR_EXIT = "[1-2]";
    private final static String GUESS_FORMAT = "[1-9]{3}";

    private String playerGuess;
    private String playerChoice;

    public ArrayList<Integer> readPlayerGuess() {
        System.out.print(REQUEST_PLAYER_GUESS);
        playerGuess = Console.readLine();
        validateGuess();

        return getGuessNumbers();
    }

    private boolean areNotUniqueNumbers() {
        HashSet<Character> guessNumbers = new HashSet<>();

        for (char guessNumber : playerGuess.toCharArray()) {
            if (guessNumbers.contains(guessNumber)) {
                return true;
            }
            guessNumbers.add(guessNumber);
        }

        return false;
    }

    private void validateGuess() {
        if ( !playerGuess.matches(GUESS_FORMAT) || areNotUniqueNumbers()) {
            throw new IllegalArgumentException("올바른 형식으로 입력해주세요.");
        }
    }

    private ArrayList<Integer> getGuessNumbers() {
        ArrayList<Integer> guessNumbers = new ArrayList<>();
        Arrays.stream(playerGuess.split("")).map(Integer::parseInt).forEach(guessNumbers::add);

        return guessNumbers;
    }

    public int readPlayerChoice() {
        System.out.println(REQUEST_PLAYER_CHOICE);
        playerChoice = Console.readLine();
        validateChoice();

        return Integer.parseInt(playerChoice);
    }

    private void validateChoice() {
        if (!playerChoice.matches(RESTART_OR_EXIT)) {
            throw new IllegalArgumentException("올바른 형식으로 입력해주세요.");
        }
    }
}
