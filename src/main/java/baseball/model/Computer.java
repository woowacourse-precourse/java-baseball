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

        if (strikeCount == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
            GamePlay.restart = true;
        }

        resetHint();
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

    private void resetHint() {
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

    public int[] getNumbers() {
        return numbers;
    }
}
