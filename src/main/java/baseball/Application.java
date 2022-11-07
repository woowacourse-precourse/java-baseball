package baseball;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();

        game.start();

        try {
            game.play();
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 값이 입력되어 애플리케이션을 종료합니다.");
            return;
        }


    }
}
