package baseball.service;

import baseball.utils.PrintMessage;
import baseball.utils.RandomNumber;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InGame {


    public int[] userInputToInt(String input) {
        validate(input);
        return getParseInt(input);
    }

     private void validate(String input) throws IllegalArgumentException {
        isInteger(input);
        lengthCheck(input);
        duplicateNum(input);
    }

    private void lengthCheck(String input) throws IllegalArgumentException{
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private void isInteger(String input) throws IllegalArgumentException{
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e); // IllegalArgumentException 이 아닌 NumberFormatException 을 던지는 이슈있음
        }
    }

    private void duplicateNum(String input) throws IllegalArgumentException{
        List<Character> numList = new ArrayList<>(0);
        for (int i = 0; i < input.length(); i++) {
            numList.add(input.charAt(i));
            if(numList.size() != numList.stream().distinct().count()){
                throw new IllegalArgumentException();
            }
        }
    }

    private int[] getParseInt(String input) throws IllegalArgumentException{
        int[] parseInt = new int[3];

        for (int i = 0; i < input.length(); i++) {
            if (!checkDigit(input, i)) {
                throw new IllegalArgumentException();
            }
            parseInt[i] = charToInt(input, i);
        }
        return parseInt;
    }

    private Boolean checkDigit(String input, int i) {
        return '0' < input.charAt(i) && input.charAt(i) <= '9';
    }

    private int charToInt(String input, int i) {
        return input.charAt(i) - '0';
    }
}
