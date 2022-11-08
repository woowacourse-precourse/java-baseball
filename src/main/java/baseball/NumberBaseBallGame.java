package baseball;

import baseball.player.Computer;
import baseball.player.User;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.regex.Pattern;

public class NumberBaseBallGame {

    private final User user;
    private final Computer computer;
    private boolean isEnd;

    public NumberBaseBallGame(User user, Computer computer) {
        this.user = user;
        this.computer = computer;
        this.isEnd = false;
    }

    private void selectBalls() {
        user.selectBalls();
        computer.selectBalls();
    }

    private void processingGameResult() {
        List<String> userSelectedBalls = user.getSelectBalls();
        List<String> computerSelectedBalls = computer.getSelectBalls();

        if (isNothing(userSelectedBalls, computerSelectedBalls)) {
            Message.NOTHING.print();
            return;
        }

        int strike = getStrike(userSelectedBalls, computerSelectedBalls);
        int ball = getBall(userSelectedBalls, computerSelectedBalls, strike);
        Message.printGameResult(strike, ball);

        if (isEverythingRight(strike)) {
            Message.END.print();
            this.isEnd = true;
        }
    }

    private boolean isNothing(List<String> userSelectBalls, List<String> computerSelectBalls) {
        return userSelectBalls.stream()
            .noneMatch(computerSelectBalls::contains);
    }

    private int getStrike(List<String> userSelectBalls, List<String> computerSelectBalls) {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            String userSelectBall = userSelectBalls.get(i);
            String computerSelectBall = computerSelectBalls.get(i);
            if (userSelectBall.equals(computerSelectBall)) {
                strike++;
            }
        }
        return strike;
    }

    private int getBall(
        List<String> userSelectedBalls,
        List<String> computerSelectedBalls,
        int strike
    ) {
        int countEqualBalls = (int) userSelectedBalls.stream()
            .filter(computerSelectedBalls::contains)
            .count();
        return countEqualBalls - strike;
    }

    private boolean isEverythingRight(int strike) {
        return strike == 3;
    }

    private void restart() {
        isEnd = false;
        computer.clearSelectBalls();
    }

    private boolean getRestartFlag() {
        String restartNumber = Console.readLine();
        if (isNotRestartNumber(restartNumber)) {
            throw new IllegalArgumentException();
        }
        return restartNumber.equals(Flag.RESTART.getValue());
    }

    private boolean isNotRestartNumber(String restartFlag) {
        Pattern notRestartNumberPattern = Valid.NOT_RESTART_NUMBER.getPattern();
        return notRestartNumberPattern.matcher(restartFlag).find();
    }
}
