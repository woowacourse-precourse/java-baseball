package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game();
        GameException gameException = new GameException();

        System.out.println("숫자 야구 게임을 시작합니다.");

        do{
            game.startGame(gameException);

        }while (game.restartGame(gameException) != 2);

    }

}
