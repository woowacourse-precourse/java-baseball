package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {

    }

    // 2. Print the game start message
    public static String printTheGameStartMessage() {
        return "숫자 야구 게임을 시작합니다.";
    }

    /*
     3. Get random number
     - get random number after making sure all digits are different
     */
    public static String getRandomNumber() {
        List<String> numberList = new ArrayList<>();

        while (numberList.size() < 3) {
            String digit = String.valueOf(Randoms.pickNumberInRange(1, 9));

            numberList = updateNumberList(digit, numberList);
        }

        return String.join("", numberList);
    }

    private static List<String> updateNumberList(String digit, List<String> numberList) {
        if (!numberList.contains(digit)) {
            numberList.add(digit);
        }
        return numberList;
    }

    // 4. Guess number
    public static String guessNumber() {
        System.out.println("숫자를 입력해주세요: ");
        return Console.readLine();
    }

    // 5. IllegalArgumentException handler
    public static boolean isInputNumberValid(String inputNumber) {

        // 길이 제한
        if (inputNumber.length() != 3) {
            throw new IllegalArgumentException("게임 종료");
        }

        String[] digits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        // 유효한 문자
        HashSet<Boolean> checkResult = new HashSet<Boolean>();

        for (char n : inputNumber.toCharArray()) {
            checkResult.add(Arrays.stream(digits).anyMatch(String.valueOf(n)::contains));
        }

        if (checkResult.contains(false)) {
            throw new IllegalArgumentException("게임 종료");
        }

        return true;
    }

    // 7. Judge strike
    public static int judgeStrike(String currentNumberOfInput, String numberOfTheAnswerInSameIndex, String answer) {
        if (answer.contains(currentNumberOfInput) && numberOfTheAnswerInSameIndex.equals(currentNumberOfInput)) {
            return 1;
        }
        return 0;
    }

    // 8. Judge ball
    public static int judgeBall(String currentNumberOfInput, String numberOfTheAnswerInSameIndex, String answer) {
        if (answer.contains(currentNumberOfInput) && !numberOfTheAnswerInSameIndex.equals(currentNumberOfInput)) {
            return 1;
        }
        return 0;
    }

}
