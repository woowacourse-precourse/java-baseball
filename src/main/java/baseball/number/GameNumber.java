package baseball.number;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class GameNumber {
    private static final Integer NUMBER_LENGTH = 3;
    private String gameNumber;

    public GameNumber() {

    }

    public GameNumber(String gameNumber) {
        this.gameNumber = gameNumber;
    }

    public static boolean isValidUserNumber(String userNumber) {
        return (isValidLength(userNumber) && isOneToNine(userNumber) && isNotDuplicatedNumber(userNumber));
    }

    private static boolean isValidLength(String userNumber) {
        return (userNumber.length() == NUMBER_LENGTH);
    }

    private static boolean isOneToNine(String userNumber) {
        return (isInZero(userNumber) && validateDigit(userNumber));

    }

    private static boolean isInZero(String userNumber) {
        return (!userNumber.contains("0"));
    }

    private static boolean validateDigit(String userNumber) {
        for (char number : userNumber.toCharArray()) {
            if (!Character.isDigit(number)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isNotDuplicatedNumber(String userNumber) {
        IntStream stream = userNumber.chars();
        return (stream.distinct().count() == NUMBER_LENGTH);
    }

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

    public String getGameNumber() {
        return gameNumber;
    }


}
