package baseball;

import baseball.domain.Computer;
import baseball.domain.User;
import camp.nextstep.edu.missionutils.Console;

import static baseball.Status.*;
import static constant.Constants.*;

public class Game {
    private final Computer computer = new Computer();
    private final User user = new User();
    private final Score score =new Score();
    private Status status;

    public Game() {
        computer.setRandNums();
        score.setAnswerNums(computer.getNums());
        status = Playing;
    }

    public void start() {
        System.out.println(START_MSG);

        while (status == Playing) {
            user.scanUserNums();

            score.setUserNums(user.getNums());
            score.countResult();
            score.showResult();
            status = score.checkingStatus();
        }

        System.out.println(GAME_FINISH_MSG);

        if (wantReplayGame()) {
            restart();
        }
    }

    private boolean wantReplayGame() {
        System.out.println(CHECKING_REPLAYING_MSG);
        int userStatus = Integer.parseInt(Console.readLine());

        if (userStatus == wantReplay) return true;
        else if (userStatus == wantEnd) return false;
        else throw new IllegalArgumentException();
    }

    private void restart() {
        computer.setRandNums();
        score.setAnswerNums(computer.getNums());
        status = Playing;
        start();
    }
}
