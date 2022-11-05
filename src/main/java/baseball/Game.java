package baseball;

import baseball.domain.Computer;
import baseball.domain.User;
import camp.nextstep.edu.missionutils.Console;

import static constant.Constants.*;

public class Game {
    private final Computer computer;
    private final User user;
    private Status status;

    public Game() {
        computer = new Computer();
        user = new User();
        status = Status.Playing;
    }

    public void start() {
        System.out.println(START_MSG);

        while (status == Status.Playing) {
            user.scanUserNums();
            countResult();
        }

        System.out.println(GAME_FINISH_MSG);
        if (checkingReplaying()) {
            restart();
        }
    }

    private void restart() {
        status = Status.Playing;
        computer.setRandNums();
        start();
    }

    private void countResult() {
        int ballCnt = 0;
        int strikeCnt = 0;

        for (int i = 0; i < ballSize; i++) {
            int cpNum = computer.getNums().get(i);
            int userNum = user.getNums().get(i);

            if (cpNum == userNum) strikeCnt++;
            else if (user.getNums().contains(cpNum)) ballCnt++;
        }

        System.out.println(showResult(ballCnt, strikeCnt));
        if (strikeCnt == ballSize) status = Status.End;
    }

    private String showResult(int ballCnt, int strikeCnt) {
        StringBuilder result = new StringBuilder();
        if (ballCnt == 0 && strikeCnt == 0) return NOTHING;

        if (ballCnt > 0) result.append(ballCnt).append(BALL);
        if (strikeCnt > 0) result.append(strikeCnt).append(STRIKE);
        return result.toString().trim();
    }

    private boolean checkingReplaying() {
        System.out.println(CHECKING_REPLAYING_MSG);
        int userStatus = Integer.parseInt(Console.readLine());

        if (userStatus == 1) return true;
        else if (userStatus == 2) return false;
        else throw new IllegalArgumentException();
    }

}
