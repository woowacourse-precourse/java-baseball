package baseball.referee;

import java.util.List;
import java.util.Map;

public class Referee {

    public int strike(int computerValueIndex, List<String> computerGeneratedValue, List<String> userInputValue) {
        int strikeCount = 0;

        for (int userValueIndex = 0; userValueIndex < 3; userValueIndex++) {
            if (userValueIndex == computerValueIndex &&
                    computerGeneratedValue.get(computerValueIndex).equals(userInputValue.get(userValueIndex))) {
                strikeCount += 1;
            }
        }

        return strikeCount;
    }
}
