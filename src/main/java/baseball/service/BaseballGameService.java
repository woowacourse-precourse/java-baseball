package baseball.service;

import baseball.domain.Computer;
import baseball.domain.PitchResult;
import baseball.util.Validate;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGameService {

    private Computer computer;
    private PitchResult pitchResult;
    private String userInput;

    public BaseballGameService() {
        pitchResult = new PitchResult();
    }

    public void initComputer() {
        computer = new Computer();
    }

    public void readUserInput() {
        String input = Console.readLine();
        Validate.inputValidate(input);
        userInput = input;
    }

    private void setBallStatus() {
        pitchResult.setResult(userInput, computer.getNumbers());
    }

    public boolean isKeepThrow() {
        return !(pitchResult.isThreeStrike());
    }

    public void throwBaseball() {
        readUserInput();
        setBallStatus();
        displayPitchStatusMessage(pitchResult.getPitchStatusMessage());
    }

    private void displayPitchStatusMessage(String pitchStatusMessage) {
        System.out.println(pitchStatusMessage);
    }
}
