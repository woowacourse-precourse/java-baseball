package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public abstract class NumberBaseballGame {

    private static List<Integer> answerNumberList = new ArrayList<>();

    public static void start() {
        setup();
        play();
        gameOver();
    }

    private static void setup() {
        printGameStartPhrase();
        pickAnswerNumberList();
    }

    private static void printGameStartPhrase() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private static void pickAnswerNumberList() {
        answerNumberList.clear(); //이전 게임에서의 정답 삭제
        while (answerNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerNumberList.contains(randomNumber)) {
                answerNumberList.add(randomNumber);
            }
        }
    }

    private static void play() {
        //TODO: 게임 진행 구현
    }

    private static void gameOver() {
        printGameOverPhrase();
    }

    private static void printGameOverPhrase() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
