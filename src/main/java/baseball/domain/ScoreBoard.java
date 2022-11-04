package baseball.domain;

import java.util.List;

public class ScoreBoard {
    private int ball;
    private int strike;
    private String result;

    public ScoreBoard(List<Integer> myBallNumbers) {
        List<Integer> computerBalls = RandomBall.computerBalls;
        for (int number : myBallNumbers) {
            if (computerBalls.contains(number)) {
                this.ball++;
            }

            if (checkStrike(computerBalls, myBallNumbers, number)) {
                this.ball--;
                this.strike++;
            }
        }
        printScoreBoard();
    }

    private void printScoreBoard() {
        if (this.ball == 0 && this.strike == 0) {
            this.result = "낫싱";
        }

        if (this.ball == 0 && this.strike != 0) {
            this.result = this.strike + "스트라이크";
        }

        if (this.ball != 0 && this.strike == 0) {
            this.result = this.ball + "볼";
        }

        if (this.ball != 0 && this.strike != 0) {
            this.result = this.ball + "볼 " + this.strike + "스트라이크";
        }
    }

    private static boolean checkStrike(List<Integer> computerBalls, List<Integer> myBallNumbers, int number) {
        return myBallNumbers.indexOf(number) == computerBalls.indexOf(number);
    }

    public void checkWin() {
        if (this.strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            GameStart.askRestartGame();
        }
    }

    public void printResult() {
        System.out.println(this.result);
    }
}
