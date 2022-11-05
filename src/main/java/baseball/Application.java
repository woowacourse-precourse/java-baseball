package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();

        baseballGame.startGame();
        List<Integer> computerNumber = baseballGame.createComputerNumber();

        while (true) {
            List<Integer> userNumber = baseballGame.getUserNumber();
            int strike = baseballGame.checkStrike(computerNumber, userNumber);
            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
            int ball = baseballGame.checkBall(computerNumber, userNumber);
            String result = baseballGame.getResult(strike, ball);
            System.out.println(result);
        }
    }
}
