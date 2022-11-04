package features;

import static features.Hint.getCountBall;
import static features.Hint.getCountNothing;
import static features.Hint.getCountStrike;

import java.util.Map;

public class AppConfig implements Factory {

    @Override
    public Map<Integer, Character> inputUserNumber() {
        return Input.inputUserNumber();
    }

    @Override
    public Map<Integer, Character> createComputerNumber() {
        return Player.createComputerNumber();
    }

    @Override
    public void loopHint(Map<Integer, Character> userNumber, Map<Integer, Character> computerNumber) {

        getCountStrike();
        getCountBall();
        getCountNothing();

    }

    @Override
    public String printResult() {
        return Print.printResult();
    }
}
