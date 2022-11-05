package baseball;

import java.util.List;


public class BaseballGame {

    private Computer computer;
    private User user;
    private Result result;
    private boolean isGameDone;
    private boolean isGameContinue;
    private List<Integer> answer;

    public BaseballGame() {
        this.computer = new Computer();
        this.user = new User();
        this.result = new Result();
    }

    public void start() {
        initGame();

        while (!isGameDone) {
            user.enterInput();

            calculateResult();
            checkGameDone();

            result.print();
            if (isGameDone) {
                System.out.println(Constants.GAME_DONE_MESSAGE);
            }
        }

        isGameContinue = user.enterRestartOrNot();
    }

    private void calculateResult() {
        List<Integer> input = user.getNumbers();
        result.reset();

        for (int i = 0; i < Constants.NUM_LENGTH; i++) {
            if (input.get(i) == answer.get(i)) {
                result.addStrike();
            } else if (answer.contains(input.get(i))) {
                result.addBall();
            }
        }
    }

    private void checkGameDone() {
        if (result.getStrike() == Constants.NUM_LENGTH && result.getBall() == 0) {
            isGameDone = true;
        }
    }

    private void initGame() {
        this.isGameDone = false;
        this.isGameContinue = false;

        computer.generateNumbers();
        answer = computer.getNumbers();
    }

    public boolean isGameContinue() {
        return isGameContinue;
    }
}
