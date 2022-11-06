package baseball;

public class Application {
    public static void main(String[] args) {
        int restartOrEnd;
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            Game game = new Game();
            restartOrEnd = game.run();
        } while (restartOrEnd == 1);

    }
}
