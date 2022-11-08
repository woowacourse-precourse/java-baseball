package baseball.Count;

public class TotalCount {
    // answer: 정답, userNumber: 사용자가 입력

    private int strike;
    private int ball;

    public void initBallCount() {
        this.strike = 0;
        this.ball = 0;
    }

    public int printBallCount(int[] answer, int[] userNumber) { // 랜덤수와 사용자가 입력한수 비교
        initBallCount();

        for (int i = 0; i < answer.length; i++) {
            countStrike(answer[i], userNumber[i]);
        }
        for (int i = 0; i < answer.length; i++) {
            countBall(answer[i], userNumber);
        }

        return printResult(this.ball, this.strike);
    }

    public void countStrike(int answer, int userNumber) {
        if (answer == userNumber)
            this.strike++;
    }

    public void countBall(int answer, int[] userAnswer) {
        for (int i = 0; i < userAnswer.length; i++) {
            if (answer == userAnswer[i]) this.ball++;
        }
    }

    public int printResult(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
            return 0;
        } else if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            return 1;
        } else if (ball == 0 && strike != 0) {
            System.out.println(strike + "스트라이크");
            return 0;
        } else if (ball != 0 && strike == 0) {
            System.out.println(ball + "볼");
            return 0;
        } else {
            System.out.println((ball - strike) + "볼 " + strike + "스트라이크");
            return 0;
        }
    }
}
