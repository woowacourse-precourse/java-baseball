package baseball;

import java.util.List;


public class BaseballGame {

    private Computer computer;
    private User user;
    private Result result;
    private boolean gameDone;
    private boolean gameContinue;
    private List<Integer> answer;

    public BaseballGame() {
        this.computer = new Computer();
        this.user = new User();
        this.result = new Result();
    }

    public void start() {
        initGame();

        while (!gameDone) {
            user.enterInput();
            evaluate();
            result.print(gameDone);
        }

        gameContinue = user.enterRestartOrNot();
    }

    private void evaluate() {
        List<Integer> input = user.getNumbers();
        result.reset();

        for (int i = 0; i < Constants.NUM_LENGTH; i++) {
            if (input.get(i) == answer.get(i)) {
                result.addStrike();
            } else if (answer.contains(input.get(i))) {
                result.addBall();
            }
        }

        if (result.getStrike() == Constants.NUM_LENGTH && result.getBall() == 0) {
            gameDone = true;
        }
    }

    private void initGame() {
        this.gameDone = false;
        this.gameContinue = true;

        computer.generateNumbers();
        answer = computer.getNumbers();
    }

    public boolean isRestart() {
        return gameContinue;
    }
}
