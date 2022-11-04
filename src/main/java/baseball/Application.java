package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        CreateRandomNumber ran = new CreateRandomNumber();

        do {
            List<Integer> computer = ran.create();
            playGame(computer);
        } while (checkAgain());
    }

    private static void playGame(List<Integer> computer) {
        Ball ball;
        CompareNumber compareNumber = new CompareNumber();
        InputNumber inputNumber = new InputNumber();

        do {
            List<Integer> user = inputNumber.input();
            ball = compareNumber.compare(computer, user);
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
        } while (ball.getStrike() != 3);
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private static boolean checkAgain() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        
        if (input.equals("1"))
            return true;
        else if (input.equals("2"))
            return false;
        throw new IllegalArgumentException();
    }
}