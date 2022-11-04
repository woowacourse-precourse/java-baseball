package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseBall {
    private Balls answerBalls;

    public void start() {
        createAnswer();
    }

    public Balls createAnswer() {
        answerBalls = new Balls(List.of());
        List<Integer> answerList = new ArrayList<>();

        while (answerList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerList.contains(randomNumber)) {
                answerList.add(randomNumber);
            }
        }
        answerBalls.setNumberList(answerList);

        return answerBalls;
    }

    // 사용자에게 답을 입력받는다.

    // 사용자가 입력한 3개의 수의 예외사항을 판단한다.

    // 힌트를 판단한다.

    // 컴퓨터가 힌트를 화면에 출력한다.

    // 재시작 여부를 사용자에게 입력받는다.

    // 재시작을 판단한다.
}
