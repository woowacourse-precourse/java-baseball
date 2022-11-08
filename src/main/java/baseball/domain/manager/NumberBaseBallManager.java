package baseball.domain.manager;

import baseball.constant.GameMessage;
import baseball.constant.GameStatus;
import baseball.domain.computer.Computer;
import baseball.domain.user.User;
import baseball.util.BallCount;

import java.io.IOException;

public class NumberBaseBallManager {

    private GameStatus status = GameStatus.NOT_INITIALIZED;
    private final User user = new User();

    public void validate(String input) throws IllegalArgumentException {
        GameStatus currentStatus = getStatus();
        if (currentStatus == GameStatus.IN_GAME) {
            validateGuess(input);
            return;
        }

        if (currentStatus == GameStatus.PENDING) {
            validateAnswerContinueOrNot(input);
        }
    }

    public void validateAnswerContinueOrNot(String input)
            throws IllegalArgumentException {
        if (input.length() != 1) {
            throw new IllegalArgumentException();
        }

        int val = input.charAt(0) - '0';
        if (val != 1 && val != 2) {
            throw new IllegalArgumentException();
        }
    }

    public void validateGuess(String input) throws IllegalArgumentException {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }

        int sum = 0;
        boolean[] visit = new boolean[10];

        for (int i = 0; i < 3; i++) {
            int digit = getDigit(input.charAt(i));
            checkDuplicate(digit,visit);
            sum = sum*10 + digit;
        }
    }

    private void checkDuplicate(int digit,boolean[] visit) throws IllegalArgumentException {
        if (visit[digit]) throw new IllegalArgumentException();
        visit[digit] = true;
    }

    private int getDigit(char character) throws IllegalArgumentException {
        int digit = character - '0';
        if (digit<=0 || digit>=10) throw new IllegalArgumentException();

        return digit;
    }

    public void checkResult(BallCount result){
        int strike = result.getStrike();

        if (strike==3) {
            status = GameStatus.PENDING;
        }
    }

    public GameStatus getStatus(){
        return this.status;
    }
}
