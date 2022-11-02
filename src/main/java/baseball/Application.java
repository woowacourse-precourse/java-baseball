package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final int answerLength = 3;

    private static List<Integer> startGame() {

        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> correctAnswer = new ArrayList<>();
        while (correctAnswer.size() < answerLength) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!correctAnswer.contains(randomNumber)) {
                correctAnswer.add(randomNumber);
            }
        }
        return  correctAnswer;
    }

    public static void main(String[] args) {

        // TODO: 프로그램 구현
    }
}
