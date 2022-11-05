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
        validateInputNumber(playerNumber, PLAYER_NUMBER_LENGTH);
        return playerNumber;
    }

    private void validateInputNumber(String playerNumber, int numberLength) throws IllegalArgumentException {
        //정수인지, 길이가 맞는지, 반복되는 수 없는지 검사
        validateNumberOrNotNumber(playerNumber);
        validateNumberLength(playerNumber, numberLength);
        validateNumberRepeat(playerNumber);
    }

    private void validateNumberOrNotNumber(String playerNumber) {
        boolean regex = Pattern.matches(PATTERN, playerNumber);
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
        //해당 수도 validation 필요
        String playerNumber = readLine();
        validateNumberOrNotNumber(playerNumber);
        validateNumberLength(playerNumber, RESTART_OR_END_NUMBER_LENGTH);
        return Integer.parseInt(playerNumber);
    }
}