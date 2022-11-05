package baseball;

import java.util.List;


public class BaseballGame {

    private Computer computer;
    private User user;
    private boolean gameContinueFlag;
    private List<Integer> answer;

    public void start() {
        gameContinueFlag = true;

        System.out.println(Constants.START_MESSAGE);
        initGame();

        while (gameContinueFlag) {
            user.enterInput();
        }
    }

    private void initGame() {
        this.computer = new Computer();
        this.user = new User();

        computer.generateNumbers();
        answer = computer.getNumbers();
    }

    public boolean isRestart() {
        return gameContinueFlag;
    }

}
