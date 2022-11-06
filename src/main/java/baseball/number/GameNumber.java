package baseball.number;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class GameNumber {
    private static final Integer NUMBER_LENGTH = 3;
    private String gameNumber;

    public void generateRandomNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }

        this.gameNumber = computerNumber.toString();
    }

    public boolean isValidUserNumber(String userNumber) {
        return (isValidLength(userNumber) && isOneToNine(userNumber) && isNotDuplicatedNumber(userNumber));
    }

    public boolean isValidLength(String userNumber) {
        return (userNumber.length() == NUMBER_LENGTH);
    }

    public boolean isOneToNine(String userNumber) {
        return (isInZero(userNumber) && validateDigit(userNumber));

    }

    public boolean isInZero(String userNumber) {
        return (!userNumber.contains("0"));
    }

    public boolean validateDigit(String userNumber) {
        for (char number : userNumber.toCharArray()) {
            if (!Character.isDigit(number)) {
                return false;
            }
        }

        return true;
    }




}
