package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Application {

    private static boolean isNothing(List<Integer> userNumber, List<Integer> computerNumber) {
        return Collections.disjoint(userNumber, computerNumber);
    }

    private static void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");
    }

    private static boolean isValidScope(String userNumber) {
        return userNumber.matches("[1-9]+");
    }

    private static boolean isThreeLength(String userNumber) {
        return userNumber.length() == 3;
    }

    private static boolean isDuplicate(String userNumber) {
        Set<Character> notDuplication = new HashSet<>();
        for (int index = 0; index < userNumber.length(); index ++) {
            notDuplication.add(userNumber.charAt(index));
        }
        return notDuplication.size() == userNumber.length();
    }

    private static List<Integer> getUserNumber() throws IllegalArgumentException {
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

    private static void createComputerNumber(List<Integer> computerNumber) {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (!computerNumber.contains(randomNumber)) {
            computerNumber.add(randomNumber);
        }
    }

    private static List<Integer> getComputerNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            createComputerNumber(computerNumber);
        }
        return computerNumber;
    }

    public static void main(String[] args) {
        List<Integer> userNumber = new ArrayList<>();
        try {
            userNumber = getUserNumber();
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }
    }
}
