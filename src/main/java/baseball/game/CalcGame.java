package baseball.game;

import baseball.object.GameResult;
import baseball.object.StrikeNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CalcGame {
    private static StrikeNumber number;
    private static final Integer LENGTH = 3;

    public static void setStrikeNumber(StrikeNumber strikeNumber) {
        number = strikeNumber;
    }

    public static void setStrikeNumber(Integer strikeNumber) {

        List<Integer> numberList = new ArrayList<>();

        while (strikeNumber != 0) {
            numberList.add(strikeNumber % 10);
            strikeNumber /= 10;
        }

        Collections.reverse(numberList);
        number = new StrikeNumber(numberList);
    }

    public static GameResult calcGameResult(Integer inputNumber) throws IllegalArgumentException {

        List<Integer> userNumber = new ArrayList<>();

        while (inputNumber > 0) {
            Integer restNumber = inputNumber % 10;

            checkNumberRange(restNumber);
            checkNumberDuplicate(userNumber, restNumber);

            userNumber.add(restNumber);
            inputNumber /= 10;
        }

        checkNumberLength(userNumber);
        Collections.reverse(userNumber);

        Integer ball = 0;
        Integer strike = 0;

        for (int i = 0; i < LENGTH; i++) {
            Integer idx = number.getNumber().indexOf(userNumber.get(i));

            if (idx.equals(i)) {
                strike += 1;
            } else if (idx != -1) {
                ball += 1;
            }
        }

        return new GameResult(ball, strike);
    }

    private static void checkNumberRange(Integer number) throws IllegalArgumentException {
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException("Number length is 1 to 9");
        }
    }

    private static void checkNumberLength(List<Integer> list) throws IllegalArgumentException {
        if (list.size() != LENGTH) {
            throw new IllegalArgumentException("Number length out of range");
        }
    }

    private static void checkNumberDuplicate(List<Integer> numberList, Integer number) {
        if (numberList.contains(number)) {
            throw new IllegalArgumentException("Numbers must consist of different letters");
        }
    }
}
