package baseball;

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
    public static String generateGoalNumber() {
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
    public static String getUserNumber() {
        String result = readLine();
        return result;
    }

    /**
     * 사용자로부터 받은 입력이 주어진 규칙에 맞는지 확인
     *
     * @param input
     * @return
     */
    public static Boolean isValidInput(String input) {
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
    public static List<Integer> compareTwoNumbers(String target, String input) {
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
     * 결과에 맞는 텍스트 출력
     *
     * @param input
     */
    public static void printTrialResult(List<Integer> input) {
        if (input.get(0) == 0 && input.get(1) == 0) {
            System.out.println("낫싱");
            return;
        }
        if (input.get(0) == 0) {
            System.out.println(input.get(1) + "볼");
        }
        if (input.get(1) == 0) {
            System.out.println(input.get(0) + "스트라이크");
        }
        System.out.println(input.get(1) + "볼 " + input.get(0) + "스트라이크");
        return;
    }

    /**
     * 3스트라이크 여부를 확인
     *
     * @param strikes
     * @return
     */
    public static Boolean isThreeStrikes(List<Integer> strikes) {
        if (strikes.get(0) == 3 && strikes.get(1) == 0) return true;
        return false;
    }

    /**
     * 계속할지 여부를 확인
     *
     * @return
     * @throws Exception
     */
    public static Boolean isContinue() {
        String input = readLine();
        if (input.equals("1")) return true;
        if (input.equals("2")) return false;
        throw new IllegalArgumentException();
    }

    /**
     * 숫자야구 게임 시뮬레이션
     */
    public static void simulateGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 게임 1회마다 한 번씩
        while (true) {
            String userInput = "";
            String targetNumber = "";
            targetNumber = generateGoalNumber();

            // 숫자를 맞추도록 시도한다.
            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                userInput = getUserNumber();
                if (!isValidInput(userInput)) {
                    throw new IllegalArgumentException();
                }
                List<Integer> compared = compareTwoNumbers(targetNumber, userInput);
                printTrialResult(compared);
                if (isThreeStrikes(compared)) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }
            if (!isContinue()) {
                break;
            }
        }

    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        simulateGame();
    }
}
