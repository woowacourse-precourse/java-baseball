package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Start {
    protected static final int answerLength = 3;
    private List<Integer> correctAnswer;

    public Start() {
        guideToStart();
        this.correctAnswer = setCorrectAnswer();
    }

    public List<Integer> getCorrectAnswer() {
        return this.correctAnswer;
    }

    private List<Integer> setCorrectAnswer() {
        List<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < answerLength) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }

        return  randomNumbers;
    }
    private void guideToStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }


}
