package baseball;

import java.util.List;

public class ApplicationManager {

    public void play() {
        Output.printStartMessage();
        List<Integer> computerNumbers = ComputerRandomNumbersFactory.createComputerRandomNumber();
        UserNumber userNumber = new UserNumber(Input.inputUserNumber());

        while (true) {
            int total = Comparison.compare(userNumber, computerNumbers);
            int strike = Comparison.findStrike(userNumber, computerNumbers);
            int ball = total - strike;


        }

    }

}
