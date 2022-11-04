package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        do {
            playGame(CreateRandomNumber.create());
        } while (checkAgain());
    }

    private static void playGame(List<Integer> computer) {
        List<Integer> input;

        do {
            input = InputNumber.input();
        }
        while (printHint(CompareNumber.compare(computer, input)));
    }

    private static boolean printHint(Ball ball) {
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
        return ball.getStrike() != 3;
    }

    private static boolean checkAgain() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        
        if (input.equals("1")) {
            return true;
        }
        else if (input.equals("2")) {
            System.out.println("게임 종료");
            return false;
        }
        throw new IllegalArgumentException();
    }
}