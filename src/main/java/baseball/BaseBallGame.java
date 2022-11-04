package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseBallGame {
    public static void play(List<Integer> computer) {
        Ball ball;

        do {
            ball = CompareNumber.compare(computer, InputNumber.input());
            printResult(ball);
        } while (ball.getStrike() != 3);
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private static void printResult(Ball ball) {
        if (ball.getBall() == 0 && ball.getStrike() == 0) {
            System.out.println("낫싱");
        }
        else if (ball.getBall() == 0) {
            System.out.println(ball.getStrike() + "스트라이크");
        }
        else if (ball.getStrike() == 0) {
            System.out.println(ball.getBall() + "볼");
        }
        else {
            System.out.println(ball.getBall() + "볼 " + ball.getStrike() + "스트라이크");
        }
    }

    public static boolean restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();

        if (input.equals("1")) {
            return true;
        }
        else if (input.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException();
    }
}
