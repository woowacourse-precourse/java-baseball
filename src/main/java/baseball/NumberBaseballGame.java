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
        do {
            inputPlayerNumberList();
            countBall();
            countStrike();
            printHint();
        } while(!isGameOver());
    }

    private static void inputPlayerNumberList() {
        //TODO: 플레이어로부터 숫자 입력받는 기능 구현
    }

    private static void countBall() {
        //TODO: ball 수 세기 구현
    }

    private static void countStrike() {
        //TODO: strike 수 세기 구현
    }

    private static void printHint() {
        //TODO: 플레이어가 입력한 숫자 기반 힌트 출력 구현
    }

    private static boolean isGameOver() {
        //TODO: 게임 종료 여부 반환하는 기능 구현 (3스트라이크일 때 종료)
        return false;
    }

    private static void gameOver() {
        //TODO: 게임 종료 구현
    }
}
