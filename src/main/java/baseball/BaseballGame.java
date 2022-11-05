package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    private List<Integer> answerNums;
    private List<Integer> inputNums;

    public void printGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private List<Integer> generateRandomAnswerNums() {
        List<Integer> randomNums = new ArrayList<>();
        while (randomNums.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!randomNums.contains(randomNum)) {
                randomNums.add(randomNum);
            }
        }
        return randomNums;
    }
}
