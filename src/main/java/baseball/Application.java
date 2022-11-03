package baseball;

public class Application {

    public static void main(String[] args) {
        try {
            startProgram();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    private static void startProgram() {
        do {
            NumberBaseballGame.start();
        } while (isRestartingGame());
    }

    private static boolean isRestartingGame() {
        //TODO: 게임 재시작 여부 입력 구현
        return false;
    }
}
