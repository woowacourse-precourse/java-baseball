package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    protected static final int answerLength = 3;
    public static List<Integer> correctAnswer = new ArrayList<>();


    public void start() {
        guideToStart();
        setCorrectAnswer();
    }

    private void guideToStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private void setCorrectAnswer() {
        correctAnswer.clear();

        while (correctAnswer.size() < answerLength) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!correctAnswer.contains(randomNumber)) {
                correctAnswer.add(randomNumber);
            }
        }
    }







}
