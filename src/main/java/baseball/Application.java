package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {

    public static final String ONGOING = "0";
    public static final String RESTART = "1";
    public static final String QUIT = "2";
    public static final String ANSWER = "3";

    public static List<Integer> computer;
    public static String status;
    public static int strike;
    public static int ball;

    public static void main(String[] args) {
        status = ONGOING;
        initValue();
        generateRandomNum();

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (status.equals(ONGOING)) {
            List<Integer> input = getUserInput();
            checkAnswer(input);
            printResult();

            if (status.equals(ANSWER)) checkNextStep();
        }
        System.out.println("게임 종료");
    }

    private static List<Integer> getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        validateInput(input);
        return convertInputToList(input);
    }

    private static List<Integer> convertInputToList(String input) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(input.charAt(i) - '0');
        }
        return list;
    }

    private static void generateRandomNum() {
        computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) computer.add(randomNumber);
        }
    }

    private static void validateInput(String input) {
        boolean isValidate = true;

        // 중복 체크
        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            charSet.add(input.charAt(i));
        }
        if (charSet.size() != 3) isValidate = false;

        // 자릿수 체크
        int inputNum = Integer.parseInt(input);
        if (inputNum < 100 || inputNum > 999) isValidate = false;

        if (!isValidate) throw new IllegalArgumentException("입력값이 잘못되었습니다.");
    }

    private static void checkAnswer(List<Integer> input) {
        for (int i = 0; i < 3; i++) {
            int computerNum = computer.get(i);
            int index = input.indexOf(computerNum);

            if (index == -1) continue;
            if (index == i) strike++;
            else ball++;
        }
        if (strike == 3) status = ANSWER;
    }

    private static void printResult() {
        StringBuilder result = new StringBuilder();
        if (ball > 0) result.append(ball).append("볼 ");
        if (strike > 0) result.append(strike).append("스트라이크 ");
        if (ball == 0 && strike == 0) result.append("낫싱");
        System.out.println(result);
        initValue();
    }

    private static void initValue() {
        strike = 0;
        ball = 0;
    }

    private static void checkNextStep() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String input = Console.readLine();
        if (input.equals(RESTART)) {
            status = ONGOING;
            generateRandomNum();
        } else if (input.equals(QUIT)) {
            status = QUIT;
        } else {
            throw new IllegalArgumentException("입력값이 잘못되었습니다.");
        }
    }

}
