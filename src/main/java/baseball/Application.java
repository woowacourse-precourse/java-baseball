package baseball;

import static baseball.Constant.START_PROGRAM;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        System.out.println(START_PROGRAM);
        game.startProgram();
    }
}
