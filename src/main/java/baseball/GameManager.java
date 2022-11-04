package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class GameManager {
    private ArrayList<Integer> guessNumber;
    private boolean isCorrect;

    public boolean startGame() {
        init();
        while(!isCorrect) {

            String input = Console.readLine();
            try {
                validateInput(input);
            } catch(Exception e) {
                exitGame(e);
                return false;
            }

            ArrayList<Integer> userGuess = inputToUserGuess(input);
            String resultString = getResultOfUserGuess(userGuess);
            System.out.println(resultString);

        }
        return gameover();
    }

    private void init() {

    }

    private void makeNewGuessNumber() {

    }

    private void validateInput(String input) {

    }

    private boolean isOneToNine(String input) {

    }

    private boolean isThreeChar(String input) {

    }

    private boolean hasDuplicatedDigit(String input) {

    }

    private ArrayList<Integer> inputToUserGuess(String input) {

    }

    private String getResultOfUserGuess(ArrayList<Integer> userGuess) {

    }

    private int getStrike(ArrayList<Integer> userGuess) {

    }

    private int getBall(ArrayList<Integer> userGuess) {

    }

    private boolean isNothing(int strike, int ball) {

    }

    private boolean gameover() {

    }

    private void exitGame(Exception e) {

    }
}