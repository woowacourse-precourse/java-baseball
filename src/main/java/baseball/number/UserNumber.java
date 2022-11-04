package baseball.number;

import static baseball.util.Util.convertStringToIntegerList;
import static camp.nextstep.edu.missionutils.Console.readLine;

public abstract class UserNumber {
    public static NumberDto generate() {
        String userInput = readLine();
        return new NumberDto(convertStringToIntegerList(userInput));
    }
}
