package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class BaseballGame {



    private int ball;
    private int strike;

    public BaseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        this.strike = 0;
        this.ball = 0;
    }

    public void gameStart() {
        Computer computerBalls = new Computer();
        this.strike = 0;
        this.ball = 0;
        System.out.print("숫자를 입력하세요 : ");
        String userBalls = Console.readLine();
        Exception.Check(userBalls);

        while (throwBall(userBalls, computerBalls.getComputerBalls())) {
            this.strike = 0;
            this.ball = 0;
            System.out.print("숫자를 입력하세요 : ");
            userBalls = Console.readLine();
            Exception.Check(userBalls);
        }
    }

    void ballReader(int userball, int computerball, boolean isStrike) {
        if (isStrike && userball == computerball) {
            this.strike++;
        } else if (userball == computerball) {
            this.ball++;
        }
    }
    void refereeBaseball(int userBall, ArrayList<Integer> computerBalls, int ballCount) {
        int computerBall;
        boolean isStrike;
        for (int computerBallCount = 0; computerBallCount < computerBalls.size(); computerBallCount++) {
            computerBall = computerBalls.get(computerBallCount);
            isStrike = ballCount == computerBallCount;
            ballReader(userBall, computerBall, isStrike);
        }
    }

    boolean throwBall(String userBalls, ArrayList<Integer> computerBalls) {
        for (int ballCount = 0; ballCount < userBalls.length(); ballCount++) {
            int userBall = userBalls.charAt(ballCount) - '0';
            refereeBaseball(userBall, computerBalls, ballCount);
        }

        printHint();

        if (this.strike == 3) {
            return false;
        }

        return true;
    }

    void printHint() {
        String hintMessage = "";

        if (this.ball > 0 && this.strike > 0) {
            hintMessage = this.ball + "볼 " + this.strike + "스트라이크";
        } else if (strike > 0) {
            hintMessage = this.strike + "스트라이크";
        } else if (this.ball > 0) {
            hintMessage = this.ball + "볼";
        } else if (this.strike == 0 && this.ball == 0) {
            hintMessage = "낫싱";
        }
        System.out.println(hintMessage);
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
