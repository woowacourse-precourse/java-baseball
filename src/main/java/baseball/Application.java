package baseball;


import java.util.ArrayList;
import java.util.List;

public class Application {
    static void startGame() {
        boolean getAnswer = false;
        List<Integer> gameNumbers = PlayGame.getRandomNumbers();
        while (!getAnswer) {
            List<Integer> userNumbers = PlayGame.getUserNumbers();
            List<Integer> counts = PlayGame.getCounts();
            int ball = counts.get(0);
            int strike = counts.get(1);

            if (ball + strike == 0) {
                System.out.println("낫싱");
            } else if (strike == 3) {
                System.out.println("3스트라이크");
                getAnswer = true;
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            } else if (strike == 0) {
                System.out.println(ball + "볼");
            } else if (ball == 0) {
                System.out.println(strike + "스트라이크");
            } else {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            }
        }
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
