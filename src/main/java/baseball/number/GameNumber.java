package baseball.number;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.stream.IntStream;

public class GameNumber {
    private String number;

    public GameNumber() {

    }

    public GameNumber(String userNumber) {
        this.number = userNumber;
    }
    public String getNumber(){
        return number;
    }

    public static boolean isValidateNumber(String userNumber) {
        return isValidateLength(userNumber) && isDigit(userNumber) && isNotDuplicate(userNumber);
    }

    private static boolean isValidateLength(String userNumber) {
        return userNumber.length() == 3;
    }

    private static boolean isDigit(String userNumber) {
        for (char number : userNumber.toCharArray()) {
            if (!Character.isDigit(number)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isNotDuplicate(String userNumber) {
        IntStream Stream = userNumber.chars();
        return Stream.distinct().count() == 3;
    }

    public void generate() {
        String randomNumber = "";
        while (randomNumber.length() < 3) {
            String number = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if (!randomNumber.contains(String.valueOf(number))) {
                randomNumber = randomNumber.concat(number);
            }
        }
        this.number = randomNumber;
    }
}
