package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballGameService {
    private static IntInputValidator intInputValidator;

    public static List<Integer> getPlayerNumber() {
        int playerNumberInput = StringToIntConvertor.convert(Console.readLine());
        intInputValidator = new PlayerNumberValidator();
        intInputValidator.validate(playerNumberInput);
        return Arrays.stream(String.valueOf(playerNumberInput).split("")).map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int getContinueOrBreak() {
        int continueOrBreak = StringToIntConvertor.convert(Console.readLine());
        intInputValidator = new ContinueOrBreakValidator();
        intInputValidator.validate(continueOrBreak);
        return continueOrBreak;
    }
}
