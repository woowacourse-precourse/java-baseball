package baseball;

import java.util.List;

public class ApplicationManager {

    public void play() {
        Output.printStartMessage();
        List<Integer> computerNumbers = ComputerRandomNumbersFactory.createComputerRandomNumber();
        UserNumber userNumber = new UserNumber(Input.inputUserNumber());

    }

}
