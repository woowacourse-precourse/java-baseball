package baseball;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        System.out.println(game.opening());

        do {
            try {
                game.doGame();
            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 입력입니다. 게임을 종료합니다.");
                break;
            }
        } while (game.askContinue());
    }
}
