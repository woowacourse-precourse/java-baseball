package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Player {
    public List<String> inputAnswer() throws IllegalArgumentException {
        String inputAnswer = Console.readLine();
        List<String> playerAnswer = List.of(inputAnswer.split(""));
        validate(playerAnswer);

        return playerAnswer;
    }

    public void validate(List<String> answerDigits) throws IllegalArgumentException {
        try {
            lengthThree(answerDigits);
            isInRangeNumber(answerDigits);
            distinct(answerDigits);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    public void lengthThree(List<String> answerDigits) throws IllegalArgumentException {
        if (answerDigits.size() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public void isInRangeNumber(List<String> answerDigits) throws IllegalArgumentException {
        try {
            List<Integer> intDigits = isNumber(answerDigits);
            inRange(intDigits);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> isNumber(List<String> answerDigits) throws IllegalArgumentException {
        List<Integer> intDigits = new ArrayList<>();
        for (String digit : answerDigits) {
            try {
                intDigits.add(Integer.parseInt(digit));
            } catch(NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
        return intDigits;
    }

    public void inRange(List<Integer> intDigits) throws IllegalArgumentException {
        for (Integer digit : intDigits) {
            if (digit < 1 || digit > 10) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void distinct(List<String> answerDigits) throws IllegalArgumentException {
        HashMap<String, String> digitsMap = new HashMap<>();
        for (String digit : answerDigits) {
            if (digitsMap.get(digit) != null) {
                throw new IllegalArgumentException();
            }
            digitsMap.put(digit, "checked");
        }
    }
}
