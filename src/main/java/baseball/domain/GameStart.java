package baseball.domain;

public class GameStart {
    public static boolean isWin;

    public static void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void askRestartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int restartChoice = Integer.parseInt(InputNumber.restartNum());
        if (restartChoice == 1) {
            restartGame();
        }

        if (restartChoice == 2) {
            quitGame();
        }
    }

    private static void quitGame() {
        isWin = true;
    }

    private static void restartGame() {
        isWin = false;
        RandomBall.makeNewRandomBalls();
    }
}
