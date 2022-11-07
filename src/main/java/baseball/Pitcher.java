package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Pitcher {
    private Validator validator;

    public Pitcher(Validator validator) {
        this.validator = validator;
    }

    public List<Integer> pitch() {
        String pitchValue = Console.readLine();
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
}
