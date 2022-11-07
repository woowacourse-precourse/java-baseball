package baseball;

import java.util.ArrayList;
import java.util.List;

public final class Referee {

    public static final int CONTINUATION = 0;
    public static final int END = 1;
    private static final int LIST_SIZE = 3;

    private Referee() {
    }

    public static int judge(final String guess, final List<Integer> answer) {
        List<Integer> convertedGuess = stringToIntegerList(guess);
        int ballCount = getBallCount(convertedGuess, answer);
        int strikeCount = getStrikeCount(convertedGuess, answer);
        Printer.printHintMessage(ballCount, strikeCount);
        if (answer.equals(convertedGuess)) {
            return END;
        }
        return CONTINUATION;
    }

    private static int getStrikeCount(final List<Integer> guess, final List<Integer> answer) {
        int strikeCount = 0;

        for (int position = 0; position < LIST_SIZE; position++) {
            if (isStrike(guess, answer, position)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private static boolean isStrike(final List<Integer> guess, final List<Integer> answer, final int position) {
        int guessNumber = guess.get(position);
        int answerNumber = answer.get(position);
        return guessNumber == answerNumber;
    }

    private static int getBallCount(final List<Integer> guess, final List<Integer> answer) {
        int ballCount = 0;

        for (int position = 0; position < LIST_SIZE; position++) {
            if (isBall(guess, answer, position)) {
                ballCount++;
            }
        }
        return ballCount;
    }

    private static boolean isBall(final List<Integer> guess, final List<Integer> answer, final int position) {
        int guessNumber = guess.get(position);
        int answerNumber = answer.get(position);
        return answer.contains(guessNumber) && answerNumber != guessNumber;
    }

    private static List<Integer> stringToIntegerList(final String guess) {
        List<Integer> result = new ArrayList<>();

        for (int guessIndex = 0; guessIndex < guess.length(); guessIndex++) {
            int number = asciiNumberToInt(guess.charAt(guessIndex));
            result.add(number);
        }
        return result;
    }

    private static int asciiNumberToInt(final char asciiNumber) {
        return asciiNumber - '0';
    }
}
