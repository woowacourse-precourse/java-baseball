package baseball;

import java.util.ArrayList;
import java.util.List;

public class StringParsingUtils {
    private StringParsingUtils() {

    }

    public static List<BallNumber> parseToBallNumber(String input) {
        List<BallNumber> stringParsedInput = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char currentCharacter = input.charAt(i);
            stringParsedInput.add(new BallNumber(Character.getNumericValue(currentCharacter)));
        }

        return stringParsedInput;
    }
}
