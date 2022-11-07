package baseball;

import java.util.Set;

public class Checker {

    public boolean isUserGuessRight(Set<Character> overlapChecker, String input, String randomNumber) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < 3; i++) {
            char number = input.charAt(i);
            if (number == randomNumber.charAt(i)) {
                strikeCount++;
            } else if (overlapChecker.contains(number)) {
                ballCount++;
            }
        }

        return getDecision(ballCount, strikeCount);
    }

    private boolean getDecision(int ballCount, int strikeCount) {
        Printer.getScore(ballCount, strikeCount);

        if (isWrong(strikeCount, ballCount)) {
            return false;
        }

        Printer.correctAllNumber();
        Printer.restartOrFinish();

        return true;
    }

    private boolean isWrong(int strike, int ball) {
        return strike < 3 || ball > 0;
    }

}
