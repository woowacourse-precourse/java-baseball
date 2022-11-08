package baseball.model;

import baseball.model.Ball;
import baseball.view.GameView;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static void playGame(List<Integer> computer) {
        int strikeCounter = 0;

        do {
            ArrayList<Integer> user = GameView.userNumber();
            strikeCounter = Ball.strike(user, computer);
            int ballCounter = Ball.ball(user, computer);
            boolean nothingTrue = Ball.nothing(strikeCounter, ballCounter);

            printResult(ballCounter, strikeCounter, nothingTrue);

        } while (strikeCounter != 3);

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printResult(int ball, int strike, boolean nothing) {
        if (ball != 0 && strike != 0) {
            System.out.println(ball + " 볼 " + strike + " 스트라이크");
        }
        if (ball == 0 && strike != 0) {
            System.out.println(strike + " 스트라이크");
        }
        if (ball != 0 && strike == 0) {
            System.out.println(ball + " 볼");
        }
        if (nothing) System.out.println(" 낫싱");
    }

}
