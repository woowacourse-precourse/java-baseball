package baseball;

import static constant.Constant.START_COMMENT;

public class Application {
    public static void main(String[] args) {
        boolean isContinue = true;
        System.out.println(START_COMMENT);
        Game game = new Game();
        do {
            game.start();

            if (!game.isAnswer()) {
                continue;
            }
            if (!game.canRestart()) {
                isContinue = false;
                continue;
            }
            game = new Game();
        } while (isContinue);
    }
}
