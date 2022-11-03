package baseball;

public abstract class NumberBaseballGame {

    public static void start() {
        setup();
        play();
        gameOver();
    }

    private static void setup() {
        //TODO: 게임 준비 구현
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
