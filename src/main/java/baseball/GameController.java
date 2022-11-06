package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameController {
    Computer computer = new Computer();
    String goalNumber = computer.createRandomNumber();

    public void start() {
        Message.start();
        playing();
    }

    private void playing() {
        String userNumber = getUserNumber();
        computer.getHint(userNumber, goalNumber);
    }

    public String getUserNumber() throws IllegalArgumentException {
        Message.getUserNumber();
        String userNumber = Console.readLine();

        if (!Exception.isCheckDigit(userNumber)
            || !Exception.isCheckLength(userNumber)
            || !Exception.isCheckOverlap(userNumber)
            || !Exception.isCheckRange(userNumber)) {
            throw new IllegalArgumentException();
        }
        return userNumber;
    }
}
