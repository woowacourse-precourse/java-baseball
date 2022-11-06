package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.stream.Collectors;

public class NumberManager {

    private int[] randomNumberArray;
    private static final String LENGTH = "3";
    private static final String MIN_NUMBER = "1";
    private static final String MAX_NUMBER = "9";
    private static final String REGEX = "^[" + MIN_NUMBER + "-" + MAX_NUMBER + "]{" + LENGTH + "}$";

    public void setRandomNumber() {

        StringBuilder randomNumber = new StringBuilder();

        while(randomNumber.length() < 3) {

            int pickedNumber = Randoms.pickNumberInRange(1, 9);

            if(randomNumber.indexOf(String.valueOf(pickedNumber)) == -1) {
                randomNumber.append(pickedNumber);
            }
        }

        randomNumberArray = convertToNumberArray(randomNumber);

    }

    private int[] convertToNumberArray(StringBuilder number) {

        int[] numberArray = new int[10];

        for (int i = 0; i < number.length(); i++) {
            numberArray[number.charAt(i) - '0'] = i + 1;
        }

        return numberArray;
    }

    private void validate(StringBuilder userNumber) {

        if(!userNumber.toString().matches(REGEX)) {
            throw new IllegalArgumentException();
        }

        if(Arrays.stream(userNumber.toString().split("")).collect(Collectors.toSet()).size() != 3) {
            throw new IllegalArgumentException();
        }

    }

    public ComparedNumberResult getCompareResult(StringBuilder userNumber) {

        validate(userNumber);

        int[] userNumberArray = convertToNumberArray(userNumber);

        ComparedNumberResult comparedNumberResult = new ComparedNumberResult();

        for (int i = 0; i < userNumber.length(); i++) {

            int currentUserNumber = userNumber.charAt(i) - '0';

            if(userNumberArray[currentUserNumber] == randomNumberArray[currentUserNumber]) {
                comparedNumberResult.plusStrikeCount();
                continue;
            }

            if(randomNumberArray[currentUserNumber] != 0) {
                comparedNumberResult.plusBallCount();
            }
        }

        return comparedNumberResult;
    }
}
