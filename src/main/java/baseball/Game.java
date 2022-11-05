package baseball;

import baseball.domain.Computer;
import baseball.domain.User;
import camp.nextstep.edu.missionutils.Console;

import static baseball.Status.*;
import static constant.Constants.*;

public class Game {
    private final Computer computer;
    private final User user;
    private Status status;

    public Game() {
        computer = new Computer();
        user = new User();
        status = Playing;
    }

    public void start() {
        System.out.println(START_MSG);

        while (status == Playing) {
            user.scanUserNums();

            Score nowScore = new Score(computer.getNums(),user.getNums());
            nowScore.countResult();
            nowScore.showResult();
            status = nowScore.checkingStatus();
        }

        System.out.println(GAME_FINISH_MSG);
        if (checkingReplaying()) {
            restart();
        }
    }


    private void restart() {
        status = Playing;
        computer.setRandNums();
        start();
    }


    private boolean checkingReplaying() {
        System.out.println(CHECKING_REPLAYING_MSG);
        int userStatus = Integer.parseInt(Console.readLine());

        if (userStatus == 1) return true;
        else if (userStatus == 2) return false;
        else throw new IllegalArgumentException();
    }

}
