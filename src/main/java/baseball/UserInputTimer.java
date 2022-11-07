package baseball;

import java.util.Timer;
import java.util.TimerTask;

public class UserInputTimer {
    private static final String BASEBALL_GAME_FORCE_EXIT_MESSAGE = "※ 30초 이상 입력이 없어 게임을 자동 종료합니다. ※";

    private Timer inputTimer = new Timer();
    private TimerTask taskAfterTimeout;
    private int timeout = 30;

    public UserInputTimer() {
        taskAfterTimeout = new TimerTask() {
            @Override
            public void run() {
                System.out.println(BASEBALL_GAME_FORCE_EXIT_MESSAGE);
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
