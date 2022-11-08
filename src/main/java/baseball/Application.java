package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {

    /**
     * 서로 다른 수로 이루어진 세 자리의 무작위 수를 만든다.
     *
     * @return
     */
    private static String generateGoalNumber() {
        StringBuilder sb = new StringBuilder();
        HashSet<Integer> numsLib = new HashSet<>();
        while (numsLib.size() < 3) {
            Integer tempNumber = pickNumberInRange(0, 9);
            if (!numsLib.contains(tempNumber)) {
                numsLib.add(tempNumber);
                sb.append(tempNumber.toString());
            }
        }

        String result = sb.toString();
        return result;
    }

    /**
     * 사용자로부터 입력을 받음
     *
     * @return
     */
    private static String getUserNumber() {
        String result = readLine();
        return result;
    }

    /**
     * 사용자로부터 받은 입력이 주어진 규칙에 맞는지 확인
     *
     * @param input
     * @return
     */
    private static Boolean isValidInput(String input) {
        if (input.length() != 3) return false;
        if (!input.matches("[0-9]+")) return false;
        if (input.charAt(0) == input.charAt(1) || input.charAt(1) == input.charAt(2) || input.charAt(0) == input.charAt(2))
            return false;
        return true;
    }

    /**
     * 사용자의 입력과 목표 숫자를 서로 비교하여, 스트라이크, 볼, 낫싱 여부를 확인합니다.
     *
     * @param target
     * @param input
     * @return
     */
    private static List<Integer> compareTwoNumbers(String target, String input) {
        List<Integer> result = Arrays.asList(0, 0);

        for (int i = 0; i < input.length(); i++) {
            if (!target.contains(Character.toString(input.charAt(i)))) {
                continue;
            }
            if (target.charAt(i) == input.charAt(i)) {
                result.set(0, result.get(0) + 1);
            }
            if (target.charAt(i) != input.charAt(i)) {
                result.set(1, result.get(1) + 1);
            }
        }

        return result;
    }

    /**
     * 3스트라이크 여부를 확인
     *
     * @param strikes
     * @return
     */
    private static Boolean isThreeStrikes(List<Integer> strikes) {
        if (strikes.get(0) == 3 && strikes.get(1) == 0) return true;
        return false;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
