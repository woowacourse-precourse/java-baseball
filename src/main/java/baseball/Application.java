package baseball;


public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballGame game = new BaseballGame();
        while (true) {
            int result = game.run();
            if (result == 2) break; // 1: 게임 재시작, 2: 게임 종료
        }

    }
}
