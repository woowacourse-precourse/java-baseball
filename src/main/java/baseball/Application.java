package baseball;

public class Application {

    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        Game game = new Game();
        while (game.gameEnd()) {
            game.playGame();
        }
    }
}

