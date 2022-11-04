package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
    }

    private static String getRandomThreeDigitNumberString() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        StringBuilder threeDigitNumberStringBuilder = new StringBuilder();

        for (Integer digitNumber : computer) {
            threeDigitNumberStringBuilder.append(digitNumber);
        }

        return String.valueOf(threeDigitNumberStringBuilder);
    }

    private static String userInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInputString = Console.readLine();
        System.out.println(userInputString);

        userInputValidation(userInputString);
        return userInputString;
    }

    private static void userInputValidation(String userInputString) {
        String pattern = "^[1-9]{3}$";
        if (!Pattern.matches(pattern, userInputString)) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < userInputString.length(); i++) {
            String indexDigitNumber = userInputString.charAt(i) + "";
            String checkOverlapString = userInputString.replace(indexDigitNumber, "");

            if (checkOverlapString.length() < 2) {
                throw new IllegalArgumentException();
            }
        }
    }
}
