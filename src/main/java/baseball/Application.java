package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        List<String> computerNumber = getComputerNumber();

        List<String> userInput = new ArrayList<>(Arrays.asList(readLine().split("")));
        if (!isValidLength(userInput) || !isExistOnlyNumber(userInput)) {
            throw new IllegalArgumentException();
        }
    }

    private static ArrayList<String> getComputerNumber() {
        ArrayList<String> computerNumber = new ArrayList<>();

        while (computerNumber.size() < 3) {
            String number = Integer.toString(Randoms.pickNumberInRange(1, 9));

            if (!computerNumber.contains(number)) {
                computerNumber.add(number);
            }
        }

        return computerNumber;
    }

    private static boolean isValidLength(List<String> userInput) {
        return userInput.size() == 3;
    }

    private static boolean isExistOnlyNumber(List<String> userInput) {
        boolean isOnlyNumber = false;

        for (String element : userInput) {
            isOnlyNumber = isOnlyNumber || Character.isDigit(element.charAt(0));
        }
        return isOnlyNumber;
    }
}
