package baseball;

import baseball.validators.PlayAgainOrNotValidator;
import baseball.validators.ThreeDiffDigitValidator;
import camp.nextstep.edu.missionutils.Console;

public class Gamer {
    public String inputThreeDiffDigit() {
        String input = Console.readLine();
        new ThreeDiffDigitValidator().validate(input);
        return input;
    }

    public String inputPlayAgainOrNot() {
        String input = Console.readLine();
        new PlayAgainOrNotValidator().validate(input);
        return input;
    }
    
}
