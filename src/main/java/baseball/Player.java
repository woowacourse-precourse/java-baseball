package baseball;

import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static constants.GameConstant.*;

public class Player {
    public String getPlayerNumber() throws IllegalArgumentException{
        System.out.print(INPUT_NUMBER_MESSAGE);
        String playerNumber = readLine();
        validateInputNumber(playerNumber, GAME_NUMBER_LENGTH);
        return playerNumber;
    }

    private void validateInputNumber(String playerNumber, int numberLength) throws IllegalArgumentException {
        validateNumberOrNotNumber(playerNumber, PATTERN);
        validateNumberLength(playerNumber, numberLength);
        validateNumberRepeat(playerNumber);
    }

    private void validateNumberOrNotNumber(String playerNumber, String regexPattern) {
        boolean regex = Pattern.matches(regexPattern, playerNumber);
        if (!regex) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumberLength(String playerNumber, int numberLength) {
        if (playerNumber.length() != numberLength) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumberRepeat(String playerNumber) {
        HashSet<String> setNumber = new HashSet<>(
                Arrays.asList(playerNumber.split(""))
        );
        if (setNumber.size() != playerNumber.length()) {
            throw new IllegalArgumentException();
        }
    }

    public int getRestartOrEndNumber(){
        System.out.println(RESTART_OR_END_MESSAGE);
        String playerNumber = readLine();
        validateNumberOrNotNumber(playerNumber, RESTART_OR_END_PATTERN);
        validateNumberLength(playerNumber, RESTART_OR_END_NUMBER_LENGTH);
        return Integer.parseInt(playerNumber);
    }
}