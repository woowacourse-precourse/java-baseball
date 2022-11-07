package baseball;

import java.util.HashSet;
import java.util.Set;

public class Checker {

    private Set<Character> ballCounter;

    public boolean isUserGuessRight(String input, String randomNumber) {

        init(randomNumber);

        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < 3; i++) {
            char number = input.charAt(i);
            if (number == randomNumber.charAt(i)) {
                strikeCount++;
            } else if (ballCounter.contains(number)) {
                ballCount++;
            }
        }

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

    private void init(String randomNumber) {
        this.ballCounter = new HashSet<>();

        for (char number : randomNumber.toCharArray()) {
            ballCounter.add(number);
        }
    }

}
