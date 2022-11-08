package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    private static BaseballGameInputFilter inputFilter = BaseballGameInputFilter.getInstance();

    private BaseballRefree refree = new BaseballRefree();
    private boolean isContinued = true;

    public void runBaseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (isContinued) {
            refree.setAnswerNumber(this.getAnswerNumber());

            while (!refree.judge(inputFilter.readNumbers())) {
                continue;
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

            isContinued = inputFilter.readIsContinued();
        }
    }

    private String getAnswerNumber() {
        List<Integer> answerNumbers = new ArrayList<>();
        String answerString = "";

        while (answerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if (!answerNumbers.contains(randomNumber)) {
                answerString += String.valueOf(randomNumber);
                answerNumbers.add(randomNumber);
            }
        }
        return answerString;
    }

}
