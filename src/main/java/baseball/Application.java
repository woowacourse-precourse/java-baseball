package baseball;

public class Application {
    private static final String GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static Game game;

    public static void main(String[] args) {
        boolean isContinue;
        do {
            game = new Game();
            game.run();
            System.out.println(GAME_RESTART_MESSAGE);
            isContinue = game.toBeContinue();
        }while(isContinue);
    }
}