package baseball;

import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static constants.GameConstant.*;

public class Player {
    public String getPlayerNumber() throws IllegalArgumentException{
        System.out.println(INPUT_NUMBER_MESSAGE);
        String playerNumber = readLine();
        validateInputNumber(playerNumber);
        return playerNumber;
    }

    private void validateInputNumber(String playerNumber) throws IllegalArgumentException {
        //정수인지, 길이가 맞는지, 반복되는 수 없는지 검사
        validateNumberOrNotNumber(playerNumber);
        validateNumberLength(playerNumber);
        validateNumberRepeat(playerNumber);
    }

    private void validateNumberOrNotNumber(String playerNumber) {
        String pattern = "^[0-9]*$"; //숫자만
        boolean regex = Pattern.matches(pattern, playerNumber);
        if (!regex) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumberLength(String playerNumber) {
        if (playerNumber.length() != NUMBER_LENGTH) {
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
}
