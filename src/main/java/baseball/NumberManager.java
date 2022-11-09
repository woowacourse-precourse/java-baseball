package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class NumberManager {

    private ArrayList<Integer> randomNumberArray;
    private static final int LENGTH = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final String REGEX = "^[" + MIN_NUMBER + "-" + MAX_NUMBER + "]{" + LENGTH + "}$";

    public void setRandomNumber() {

        StringBuilder randomNumber = new StringBuilder();

        while (randomNumber.length() < LENGTH) {

            int pickedNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);

            if (randomNumber.indexOf(String.valueOf(pickedNumber)) == -1) {
                randomNumber.append(pickedNumber);
            }
        }

        randomNumberArray = convertToNumberArray(randomNumber);

    }

    private ArrayList<Integer> convertToNumberArray(StringBuilder number) {

        ArrayList<Integer> numberArray = new ArrayList<>();

        for (int i = 0; i <= MAX_NUMBER; i++) {
            numberArray.add(0);
        }

        for (int i = 0; i < number.length(); i++) {
            numberArray.set(number.charAt(i) - '0', i + 1);
        }

        return numberArray;
    }

    public void validate(StringBuilder userNumber) {

        if (!userNumber.toString().matches(REGEX)) {
            throw new IllegalArgumentException();
        }

        if (Arrays.stream(userNumber.toString().split("")).collect(Collectors.toSet()).size() != LENGTH) {
            throw new IllegalArgumentException();
        }

    }

    public ComparedNumberResult getComparedResult(StringBuilder userNumber) {

        ArrayList<Integer> userNumberArray = convertToNumberArray(userNumber);

        ComparedNumberResult comparedNumberResult = new ComparedNumberResult();

        for (int i = 0; i < userNumber.length(); i++) {

            int currentUserNumber = userNumber.charAt(i) - '0';

            if (userNumberArray.get(currentUserNumber) == randomNumberArray.get(currentUserNumber)) {
                comparedNumberResult.plusStrikeCount();
                continue;
            }

            if (randomNumberArray.get(currentUserNumber) != 0) {
                comparedNumberResult.plusBallCount();
            }
        }

        return comparedNumberResult;
    }
}
