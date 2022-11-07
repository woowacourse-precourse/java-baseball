package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    /**
     * Scan user input to start a number baseball game.
     * @return userInput
     */
    public static String getUserInput() {
        System.out.print("숫자를 입력해주세요: ");
        return readLine();
    }

    /**
     * Verify string contains characters that have been used once.
     * @param string the string to be checked.
     * @return true if no duplicate value exists.
     */
    private static boolean isDistinct(String string) {
        String[] strArr = string.split("");
        return Arrays.stream(strArr)
            .distinct()
            .count() == strArr.length;
    }

    /**
     * Generate the correct answer for a number baseball game.
     * @return answer
     */
    public static List<Integer> generateAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return answer;
    }
}
