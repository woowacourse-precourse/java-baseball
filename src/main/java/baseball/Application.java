package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    public static boolean isNumeric(String userInput) {
        for (int i = 0; i < 3; i++) {
            if (!Character.isDigit(userInput.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> makeRandomNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }

    public static List<Integer> getUserNumber() {
        List<Integer> userInputNumber = new ArrayList<>();
        String userInput = readLine();
        if (userInput.length() != 3 || !isNumeric(userInput)) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < 3; i++) {
            Integer tempNum = Integer.parseInt(String.valueOf(userInput.charAt(i)));
            if (tempNum.equals(0)) {
                throw new IllegalArgumentException();
            } else if (userInputNumber.contains(tempNum)) {
                throw new IllegalArgumentException();
            } else {
                userInputNumber.add(tempNum);
            }
        }
        return userInputNumber;
    }

    public static void main(String[] args) {
        List<Integer> computerNumber = makeRandomNumber();
        boolean flag = false;
        while (!flag) {
            List<Integer> userInputNumber;
            try {
                userInputNumber = getUserNumber();
            } catch (IllegalArgumentException exception) {
                System.out.println("올바르지 않은 입력입니다!");
                return;
            }
        }
    }
}
