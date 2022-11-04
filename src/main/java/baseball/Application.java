package baseball;

import baseball.domain.NumberBaseballGame;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        NumberBaseballGame game = new NumberBaseballGame();
        try {
            game.play();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
