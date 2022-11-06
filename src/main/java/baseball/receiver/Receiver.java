package baseball.receiver;

import baseball.GameController;
import baseball.number.GameNumber;
import camp.nextstep.edu.missionutils.Console;

public class Receiver {

    public String receiveUserNumber() throws IllegalArgumentException {
        String userNumber = Console.readLine();
        if (!GameNumber.isValidateNumber(userNumber)) {
            throw new IllegalArgumentException();
        }
        return userNumber;
    }

    public String receiveRestartNumber() throws IllegalArgumentException {
        String restartNumber = Console.readLine();
        if (!GameController.checkRestart(restartNumber)) {
            throw new IllegalArgumentException();
        }
        return restartNumber;
    }
}
