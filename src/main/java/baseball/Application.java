package baseball;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        boolean keepPlaying = true;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (keepPlaying) {
            List<Integer> targetNumber = createTargetNumber();
            guessNumber(targetNumber);
            inputKeepPlaying();
        }
    }

    private static void inputKeepPlaying() {
    }


    private static void guessNumber(List<Integer> targetNumber) {
    }

    private static List<Integer> createTargetNumber() {
        return new ArrayList<>();
    }
}
