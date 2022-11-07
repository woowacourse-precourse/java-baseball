package baseball;

import baseball.validators.ThreeDiffDigitValidator;
import camp.nextstep.edu.missionutils.Console;

public class Gamer {
    public String inputThreeDiffDigit() {
        String input = Console.readLine();
        new ThreeDiffDigitValidator().validate(input);
        return input;
    }
}
