package baseball;

public class Application {
    public static void main(String[] args) {

        boolean firstStartGame = true;

        while (firstStartGame) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            Game game = new Game();
            while (game.restartOrEnd()) {
                game.playGame();
            }
            firstStartGame = false;
        }
    }
}
