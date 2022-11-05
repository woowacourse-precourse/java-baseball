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

    public List<Integer> generateRandomAnswerNums() {
        List<Integer> randomNums = new ArrayList<>();
        while (randomNums.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!randomNums.contains(randomNum)) {
                randomNums.add(randomNum);
            }
        }
        return randomNums;
    }

    public Boolean isIllegalGameInput(int gameInput) {
        if (gameInput <= 111 || 999 <= gameInput) {
            return Boolean.FALSE;
        }

        if (checkDuplicateNums(gameInput)) {
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }

    public Boolean checkDuplicateNums(int gameInput) {
        List<Integer> checkList = new ArrayList<>();

        while (gameInput != 0) {
            int digit = gameInput % 10;
            if (checkList.contains(digit)) {
                return Boolean.TRUE;
            }
            checkList.add(digit);
            gameInput /= 10;
        }

        return Boolean.FALSE;
    }
}
