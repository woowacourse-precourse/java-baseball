package baseball.controller;

import baseball.model.number.ComputerNumber;
import baseball.model.number.HintDto;
import baseball.model.number.NumberDto;

import java.util.Arrays;

public class GameController {
    private NumberDto computerNumber;
    private NumberDto userNumber;
    private final HintDto hint;

    public GameController() {
        userNumber = new NumberDto();
        hint = new HintDto();
    }

    public void generateComputerNumber() {
        computerNumber = ComputerNumber.generate();
    }

    public void refresh() {
        ComputerNumber.generate(computerNumber);
    }

    public HintDto calculateHint() {
        // TODO
        hint.setHint(Arrays.asList(1, 1));
        return hint;
    }

    public boolean isThreeStrike() {
        // TODO
        return true;
    }

    public void setUserNumber(NumberDto userNumber) {
        this.userNumber = userNumber;
    }
}
