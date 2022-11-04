package baseball;

import java.util.ArrayList;
import java.util.List;

public class Referee {

    public static final int CONTINUATION = 0;
    public static final int END = 1;

    public static void judge(String guess, List<Integer> answer) {
        List<Integer> convertedGuess = stringToIntegerList(guess);
    }

    private static List<Integer> stringToIntegerList(String guess) {
        List<Integer> result = new ArrayList<>();

        for (int guessIndex = 0; guessIndex < guess.length(); guessIndex++) {
            int number = asciiNumberToInt(guess.charAt(guessIndex));
            result.add(number);
        }
        return result;
    }

    private static int asciiNumberToInt(char asciiNumber) {
        return asciiNumber - '0';
    }
}
