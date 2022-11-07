package baseball.model;

import baseball.controller.GamePlay;
import baseball.util.Util;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;

public class Computer {
    private int ballCount = 0;
    private int strikeCount = 0;
    private int[] numbers = new int[3];

    public void generateNumber() {
        do {
            numbers = pickNumbers();
        } while (!Util.isDuplicated(numbers));
    }

    private int[] pickNumbers() {
        return Arrays.stream(new int[3])
                .map(num -> Randoms.pickNumberInRange(1, 9))
                .toArray();
    }

    public void compare(int[] guessNumbers) {
        for (int i = 0; i < numbers.length; i++) {
            search(guessNumbers[i], i);
        }

        hintPrint();
    }

    private void hintPrint() {
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
        } else if (ballCount == 0) {
            System.out.println(strikeCount + "스트라이크");
        } else if (strikeCount == 0) {
            System.out.println(ballCount + "볼");
        } else {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
    }

    public void resetHint() {
        ballCount = 0;
        strikeCount = 0;
    }

    private void search(int guessNumber, int index) {
        if (guessNumber == numbers[index]) {
            strikeCount++;
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (guessNumber == numbers[i]) {
                ballCount++;
            }
        }
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int[] getNumbers() {
        return numbers;
    }
}
