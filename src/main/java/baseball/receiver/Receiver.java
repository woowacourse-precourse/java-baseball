package baseball.receiver;

import baseball.BaseBallGamePlayer;
import baseball.number.GameNumber;
import camp.nextstep.edu.missionutils.Console;

public class Receiver {
    public String receiveUserNumber() {
        String userNumber = Console.readLine();

        if (!GameNumber.isValidUserNumber(userNumber)) {
            throw new IllegalArgumentException();
        }

        return userNumber;
    }

    public String receiveRestartNumber() {
        String restartNumber = Console.readLine();

        if (!BaseBallGamePlayer.isValidRestartNumber(restartNumber)) {
            throw new IllegalArgumentException();
        }

        return restartNumber;
    }


}
