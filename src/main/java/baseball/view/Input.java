package baseball.view;

import baseball.exception.InputException;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;

public class Input {
    private final static String  REQUEST_PLAYER_GUESS = "숫자를 입력해주세요 : ";
    private final static String REQUEST_PLAYER_CHOICE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private final InputException inputException;

    public Input() {
        this.inputException = new InputException();
    }

    public ArrayList<Integer> readPlayerGuess() {
        System.out.print(REQUEST_PLAYER_GUESS);
        String playerGuess = Console.readLine();
        inputException.validateGuess(playerGuess);

        return getGuessNumbers(playerGuess);
    }

    private ArrayList<Integer> getGuessNumbers(String playerGuess) {
        ArrayList<Integer> guessNumbers = new ArrayList<>();
        Arrays.stream(playerGuess.split(""))
                .map(Integer::parseInt)
                .forEach(guessNumbers::add);

        return guessNumbers;
    }

    public int readPlayerChoice() {
        System.out.println(REQUEST_PLAYER_CHOICE);
        String playerChoice = Console.readLine();
        inputException.validateChoice(playerChoice);

        return Integer.parseInt(playerChoice);
    }
}
