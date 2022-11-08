package baseball;

import java.util.List;

public class Message {
    final String ALL_STRIKE_MESSAGE = "3스트라이크";
    final String WINNING_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    final String NOTHING_MESSAGE = "낫싱";
    final String STRIKE = "스트라이크";
    final String BALL = "볼";
    private List<Integer> computerNum;

    public Message() {
        printWin();
    }

    public Message(List<Integer> computerNum, List<Integer> userNum) {
        this.computerNum = computerNum;
        printNothing(userNum);
    }

    public Message(int strike, int ball, List<Integer> computerNum, List<Integer> userNum) {
        this.computerNum = computerNum;
        printStrikeBallMessage(strike, ball, userNum);
    }

    void printStrikeBallMessage(int strike, int ball, List<Integer> userNum) {
        if (ball == 0)
            printStrike(strike, userNum);
        else if (strike == 0)
            printBall(ball, userNum);
        else
            printBallStrike(strike, ball, userNum);
    }

    void printNothing(List<Integer> userNum) {
        System.out.println(NOTHING_MESSAGE);
        User user = new User(computerNum, userNum);
    }

    void printWin() {
        System.out.println(ALL_STRIKE_MESSAGE);
        System.out.println(WINNING_MESSAGE);
        chooseCondition();
    }

    void printStrike(int strike, List<Integer> userNum) {
        System.out.println(strike + STRIKE);
        User user = new User(computerNum, userNum);
    }

    void printBall(int ball, List<Integer> userNum) {
        System.out.println(ball + BALL);
        User user = new User(computerNum, userNum);
    }

    void printBallStrike(int strike, int ball, List<Integer> userNum) {
        System.out.println(ball + BALL + " " + strike + STRIKE);
        User user = new User(computerNum, userNum);
    }

    void chooseCondition() {
        GameCondition gameCondition = new GameCondition();
    }
}
