package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        startGame();
    }

    /**
     * function to start a number baseball game.
     */
    public static void startGame() {
        List<Integer> computer = generateAnswer();
        boolean find = false;

        while(!find) {
            List<Integer> user = getInputAsList();
            find = computer.equals(user);
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    /**
     * Scan input to start a number baseball game.
     * @return list of integer if input is validated.
     */
    public static List<Integer> getInputAsList() {
        System.out.print("숫자를 입력해주세요: ");
        String userInput = readLine();

        if (!validateAnswerFormat(userInput)) {
            throw new IllegalArgumentException();
        }

        return Arrays.stream(userInput.split(""))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    /**
     * Verify string is the same format as the correct answer.
     * @param string the string to be checked.
     * @return true if string is a different number of three digits.
     */
    private static boolean validateAnswerFormat(String string) {
        return string.length() == 3
            && isNumeric(string)
            && isDistinct(string);
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
     * Verify string is numeric.
     * @param string the string to be checked.
     * @return true if string is numeric.
     */
    private static boolean isNumeric(String string) {
        try {
            Double.parseDouble(string);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
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
