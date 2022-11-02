package baseball;

import camp.nextstep.edu.missionutils.Randoms;
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

    private static List<Integer> createTargetNumber() {
        List<Integer> targetNumber = new ArrayList<>();
        while (targetNumber.size() < 3) {
            int newNumber = Randoms.pickNumberInRange(1, 9);
            if (!targetNumber.contains(newNumber)) {
                targetNumber.add(newNumber);
            }
        }
        return targetNumber;
    }

    private static void guessNumber(List<Integer> targetNumber) {
    }


    private static void inputKeepPlaying() {
    }
}
