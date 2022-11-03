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

    private static void getValidNumber(String inputUserNumber) {
        if (!isValidScope(inputUserNumber)) {
            throw new IllegalArgumentException("1 ~ 9 시이의 수만 입력할 수 있습니다.");
        }
        if (!isThreeLength(inputUserNumber)) {
            throw new IllegalArgumentException("세 자리의 수만 입력할 수 있습니다.");
        }
        if (!isDuplicate(inputUserNumber)) {
            throw new IllegalArgumentException("중복되지 않은 수만 입력할 수 있습니다.");
        }
    }

    public static List<Integer> getNumber() {
        String inputUserNumber = Console.readLine();
        List<Integer> userNumber = new ArrayList<>();
        try {
            getValidNumber(inputUserNumber);
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException(exception);
        }
        for (char element : inputUserNumber.toCharArray()) {
            userNumber.add(element - '0');
        }
        return userNumber;
    }
}
