package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    public static boolean isNumeric(String userInput) {
        ParsePosition pos = new ParsePosition(0);
        NumberFormat.getInstance().parse(userInput, pos);
        return userInput.length() == pos.getIndex();
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
            Integer tempNum = Integer.parseInt(String.valueOf(userInput.charAt(0)));
            if (tempNum.equals(0)) {
                throw new IllegalArgumentException();
            } else if (!userInputNumber.contains(tempNum)) {
                userInputNumber.add(tempNum);
            } else {
                throw new IllegalArgumentException();
            }
        }
        return userInputNumber;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> computerNumber = makeRandomNumber();
        try {
            List<Integer> userInputNumber = getUserNumber();
        } catch (IllegalArgumentException exception) {
            System.out.println("올바르지 않은 입력입니다!");
            return;
        }

    }
}
