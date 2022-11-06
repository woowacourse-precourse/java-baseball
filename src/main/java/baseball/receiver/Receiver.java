package baseball.receiver;

import baseball.number.GameNumber;
import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;

public class Receiver {
    public String receiveNumber() {
        String userNumber = Console.readLine();

        if (!GameNumber.isValidUserNumber(userNumber)) {
            throw new IllegalArgumentException();
        }

        return userNumber;
    }


}
