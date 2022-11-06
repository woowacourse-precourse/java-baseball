package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class Application {

    // 숫자 야구 게임 변수 목록
    private static List<Integer> computer = new ArrayList<>();
    private static List<Integer> input_number_list = new ArrayList<>();
    private static int ball = 0;
    private static int strike = 0;
    private static int exception_is_thrown = 0;

    private static void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        pickRandomNumber();
    }

    private static void pickRandomNumber() {
        computer.clear();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            // 중복되지 않는 3자리 수 생성 및 computer 리스트에 저장
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    private static void input() {
        System.out.print("숫자를 입력해주세요 : ");
        String input_number = String.valueOf(Console.readLine());

        input_number_list.clear();
        for (int i = 0; i < input_number.length(); i++) {
            input_number_list.add(input_number.charAt(i) - '0');
        }

        // 사용자 입력 값 중 중복된 값이 삭제된 set
        Set<Integer> set = new HashSet<>(input_number_list);
        // 사용자 입력 값이 3자리수가 아닌 경우, 0을 포함하여 입력한 경우, 중복된 값을 입력한 경우 예외처리 변수값 조정 및 예외 throw
        if (input_number_list.size() != 3 || input_number_list.contains(0) || input_number_list.size() != set.size()) {
            exception_is_thrown = 1;
            throw new IllegalArgumentException();
        }

        countBall();
    }

    private static void countBall() {

        ball = 0;
        for (Integer element : input_number_list) {
            if (isBall(element)) {
                ball++;
            }
        }

        if (ball != 0) {
            System.out.print(ball + "볼 ");
        }

        countStrike();
    }

    private static boolean isBall(Integer element) {
        return computer.contains(element) && computer.indexOf(element) != input_number_list.indexOf(element);
    }

    private static void countStrike() {

        strike = 0;
        for (Integer element : input_number_list) {
            if (isStrike(element)) {
                strike++;
            }
        }

        if (strike != 0) {
            System.out.println(strike + "스트라이크");
        }
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }
        if (ball != 0 && strike == 0) {
            System.out.println();
        }
    }

    private static boolean isStrike(Integer element) {
        return computer.contains(element) && computer.indexOf(element) == input_number_list.indexOf(element);
    }

    private static void checkRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int user_input = Integer.parseInt(Console.readLine());

        // 1 입력 시 재시작을 위해 변수 초기화
        if (user_input == 1) {
            pickRandomNumber();
            strike = 0;
            exception_is_thrown = 0;
        }

        // 1,2 이외의 수 입력 시 예외처리 변수값 조정 및 예외 throw
        if (user_input <= 0 || user_input >= 3) {
            exception_is_thrown = 1;
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {

        start();

        do {
            input();

            if (strike == 3 && exception_is_thrown == 0) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                checkRestart();
            }
            if (strike != 3 && exception_is_thrown == 1) {
                System.out.println("게임 종료");
                checkRestart();
            }

        } while (strike != 3);
    }

}
