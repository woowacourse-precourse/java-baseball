package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {

    private static boolean isValidScope(String userNumber) {
        return userNumber.matches("[1-9]+");
    }

    private static boolean isThreeLength(String userNumber) {
        return userNumber.length() == 3;
    }

    private static boolean isDuplicate(String userNumber) {
        Set<Character> notDuplication = new HashSet<>();
        for (int index = 0; index < userNumber.length(); index++) {
            notDuplication.add(userNumber.charAt(index));
        }
        return notDuplication.size() == userNumber.length();
    }

    public static List<Integer> getValidNumber() {
        List<Integer> userNumber = new ArrayList<>();
        try {
            userNumber = getNumber();
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }
        return userNumber;
    }

    private static List<Integer> getNumber() throws IllegalArgumentException {
        String inputUserNumber = Console.readLine();
        List<Integer> userNumber = new ArrayList<>();
        if (!isValidScope(inputUserNumber) || !isThreeLength(inputUserNumber)
                || !isDuplicate(inputUserNumber)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        for (char element : inputUserNumber.toCharArray()) {
            userNumber.add(element - '0');
        }
        return userNumber;
    }
}
