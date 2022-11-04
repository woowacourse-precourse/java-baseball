package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static void noticeStartGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    private static List<Integer> createComputerNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }
    private static boolean isValidUserNumbers(String userNumbers) {
        if (userNumbers.length() != 3) {
            return false;
        }
        if (!('1' <= userNumbers.charAt(0) && userNumbers.charAt(0) <= '9') ||
                !('1' <= userNumbers.charAt(1) && userNumbers.charAt(1) <= '9') ||
                !('1' <= userNumbers.charAt(2) && userNumbers.charAt(2) <= '9')) {
            return false;
        }
        return userNumbers.charAt(0) != userNumbers.charAt(1) && userNumbers.charAt(0) != userNumbers.charAt(2) &&
                userNumbers.charAt(1) != userNumbers.charAt(2);
    }
    private static String inputUserNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputUserNumbers = Console.readLine();
        if (!isValidUserNumbers(inputUserNumbers)) {
            throw new IllegalArgumentException();
        }
        return inputUserNumbers;
    }
    private static int getBallNumber(List<Integer> computerNumbers, String userNumbers) {
        int ballNumber = 0;
        for (int index = 0; index < userNumbers.toCharArray().length; ++index) {
            if (userNumbers.toCharArray()[index] - '0' != computerNumbers.get(index) &&
                    computerNumbers.contains(userNumbers.toCharArray()[index] - '0')) {
                ++ballNumber;
            }
        }
        return ballNumber;
    }
    private static int getStrikeNumber(List<Integer> computerNumbers, String userNumbers) {
        int strikeNumber = 0;
        for (int index = 0; index < userNumbers.length(); ++index) {
            if (computerNumbers.get(index) == userNumbers.toCharArray()[index] - '0') {
                ++strikeNumber;
            }
        }
        return strikeNumber;
    }
    public static void main(String[] args) {
        noticeStartGame();
        List<Integer> computerNumbers = createComputerNumbers();
        String userNumbers = inputUserNumbers();
        int ballNumber = getBallNumber(computerNumbers, userNumbers);
        int strikeNumber = getStrikeNumber(computerNumbers, userNumbers);
    }
}