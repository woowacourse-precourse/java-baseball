package baseball;

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
        //TODO: 정답 숫자 리스트 선택 기능 구현
    }

    private static void play() {
        //TODO: 게임 진행 구현
    }

    private static void gameOver() {
        //TODO: 게임 종료 구현
    }
}
