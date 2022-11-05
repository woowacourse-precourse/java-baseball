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
        initGame();

        while (!gameDone) {
            user.enterInput();
            evaluate();
            printResult();
        }

        gameContinue = user.enterRestartOrNot();
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

        if (gameDone) {
            System.out.println(Constants.GAME_DONE_MESSAGE);
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
        this.gameDone = false;
        this.gameContinue = true;

        computer.generateNumbers();
        answer = computer.getNumbers();

    }

    public boolean isRestart() {
        return gameContinue;
    }

}
