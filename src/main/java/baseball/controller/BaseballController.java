package baseball.controller;

public class BaseballController {

    public void gameStart() {
        do {
            inProgress();
        } while (restart());
    }

    public boolean restart() {
        return true;
    }

    public void inProgress() {

    }
}
