package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static baseball.Constants.*;

public class Application {

    public static void main(String[] args) {
        View.printStartMsg();
        do {
            playGame();
            View.printRestartOrEndMsg();
        } while (restartGame());
    }

    public static void playGame() {
        View.printInputMsg();
        String computer = getRandomNumber();
        while (true) {
            String userInput = Console.readLine();
            validateNumber(userInput);
            int[] counts = getStrikeAndBall(computer, userInput);
            View.printHintMsg(counts);
            if (counts[STRIKE_IDX] == NUM_OF_DIGIT) {
                View.printEndMsg();
                break;
            }
        }
    }

    public static String getRandomNumber() {
        List<String> computer = new ArrayList<>();
        while (computer.size() < NUM_OF_DIGIT) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANGE_NUM, MAX_RANGE_NUM);
            if (!computer.contains(randomNumber)) {
                computer.add(String.valueOf(randomNumber));
            }
        }
        return String.join("", computer);
    }

    public static void validateNumber(String userInput) throws IllegalArgumentException {
        if (userInput.length() != NUM_OF_DIGIT) {
            throw new IllegalArgumentException("3자리 수를 입력해주세요");
        }
        if (!isNumeric(userInput)) {
            throw new IllegalArgumentException("1과 9사이의 숫자를 입력해주세요");
        }
        if (isDuplicate(userInput)) {
            throw new IllegalArgumentException("중복이 없는 숫자를 입력해주세요");
        }
    }

    public static boolean isNumeric(String input) {
        for (int iter = 0; iter < NUM_OF_DIGIT; iter++) {
            char c = input.charAt(iter);
            if (c < '1' || c > '9') {
                return false;
            }
        }
        return true;
    }

    public static boolean isDuplicate(String input) {
        List<Integer> list = new ArrayList<>();
        String[] strList = input.split("");
        for (int iter = 0; iter < NUM_OF_DIGIT; iter++) {
            list.add(Integer.parseInt(strList[iter]));
        }
        Set<Integer> set = new HashSet<>(list);
        if (list.size() != set.size()) {
            return true;
        }
        return false;
    }

    public static int[] getStrikeAndBall(String computer, String user) {
        int[] counts = new int[2];
        for (int iter = 0; iter < NUM_OF_DIGIT; iter++) {
            if (computer.charAt(iter) == user.charAt(iter)) {
                counts[STRIKE_IDX]++;
                continue;
            }
            if (computer.contains(String.valueOf(user.charAt(iter)))) {
                counts[BALL_IDX]++;
            }
        }
        return counts;
    }

    private static boolean restartGame() {
        String userInput = Console.readLine();
        validateRestartOrEnd(userInput);
        if (userInput.equals("1")) {
            return true;
        }
        return false;
    }

    public static void validateRestartOrEnd(String userInput) throws IllegalArgumentException {
        if (!userInput.matches("[1-2]")) {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요");
        }
    }
}
