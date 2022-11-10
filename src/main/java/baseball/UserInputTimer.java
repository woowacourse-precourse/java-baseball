package baseball;

import java.util.Timer;
import java.util.TimerTask;

import static baseball.InGameMessage.BASEBALL_GAME_FORCE_EXIT_MESSAGE;

public class UserInputTimer {
    private Timer inputTimer = new Timer();
    private TimerTask taskAfterTimeout;
    private int timeout = 30;

    public UserInputTimer() {
        taskAfterTimeout = new TimerTask() {
            @Override
            public void run() {
                System.out.printf(BASEBALL_GAME_FORCE_EXIT_MESSAGE.getMessage(),timeout);
                System.exit(0);
            }
        };
    }

    public void setTimer() {
        inputTimer.schedule(taskAfterTimeout, timeout * 1000);
    }

    public void closeTimer() {
        inputTimer.cancel();
    }
}
