package baseball;

import java.util.List;


public class BaseballGame {

    private Computer computer;
    private User user;
    private boolean gameDone;
    private boolean gameContinue;
    private List<Integer> answer;
    private int[] result;

    public void start() {
        System.out.println(Constants.START_MESSAGE);
        initGame();

        while (!gameDone) {
            user.enterInput();
            evaluate();
            printResult();
        }
    }

    private void printResult() {
        int strike = result[0];
        int ball = result[1];

        if (strike == 0 && ball == 0) {
            System.out.println(Constants.NOTHING_MESSAGE);
        } else if (ball == 0) {
            System.out.println(strike + Constants.STRIKE_MESSAGE);
        } else if (strike == 0) {
            System.out.println(ball + Constants.BALL_MESSAGE);
        } else {
            System.out.print(strike + Constants.STRIKE_MESSAGE + " ");
            System.out.println(ball + Constants.BALL_MESSAGE);
        }
    }

    private void evaluate() {
        List<Integer> input = user.getNumbers();
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < Constants.NUM_LENGTH; i++) {
            if (input.get(i) == answer.get(i)) {
                strike += 1;
            } else if (answer.contains(input.get(i))) {
                ball += 1;
            }
        }

        result[0] = strike;
        result[1] = ball;

        if (strike == 3) {
            gameDone = true;
        }
    }

    private void initGame() {
        this.computer = new Computer();
        this.user = new User();
        this.result = new int[2];

        computer.generateNumbers();
        answer = computer.getNumbers();

        gameDone = false;
        gameContinue = true;
    }

    public boolean isRestart() {
        return gameContinue;
    }

}
