package baseball;

import baseball.domain.Computer;
import baseball.domain.User;
import camp.nextstep.edu.missionutils.Console;

import static baseball.Status.*;
import static constant.Constants.*;

public class Game {
    private final Computer computer;
    private final User user;
    private final Score score;
    private Status status;


    public Game() {
        computer = new Computer();
        user = new User();
        score = new Score(computer.getNums());
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
        if (replayingGame()) {
            restart();
        }
    }

    private boolean replayingGame() {
        System.out.println(CHECKING_REPLAYING_MSG);
        int userStatus = Integer.parseInt(Console.readLine());

        if (userStatus == 1) return true;
        else if (userStatus == 2) return false;
        else throw new IllegalArgumentException();
    }

    private void restart() {
        computer.setRandNums();
        score.setAnswer(computer.getNums());
        status = Playing;
        start();
    }
}
