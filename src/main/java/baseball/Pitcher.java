package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Pitcher {
    private Validator validator;

    public Pitcher(Validator validator) {
        this.validator = validator;
    }

    public List<Integer> pitch() {
        String pitchValue = readLine();
        validator.validatePitchValue(pitchValue);
        return convertInputToIntegerList(pitchValue);
    }

    private List<Integer> convertInputToIntegerList(String pitchValue) {
        List<Integer> digits = new ArrayList<>();
        for (int idx = 0; idx < pitchValue.length(); idx++) {
            digits.add(pitchValue.charAt(idx) - '0');
        }
        return digits;
    }

    public Integer selectGameRestartOrEnd() {
        String gameProcessValue = readLine();
        validator.validateGameProcessValue(gameProcessValue);
        return Integer.valueOf(gameProcessValue);
    }
}
