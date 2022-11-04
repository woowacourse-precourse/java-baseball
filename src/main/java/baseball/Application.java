package baseball;

import camp.nextstep.edu.missionutils.Console;

import static constant.Constant.*;
import static constant.ErrorMessage.INVALID_INPUT_VALUE;

public class Application {
    public static void main(String[] args) {
        boolean isContinue = true;
        PrintComment.printStartComment();
        Game game = new Game();
        do {
            game.start();

            if (!game.isAnswer()) {
                continue;
            }
            if (!game.canRestart()){
                isContinue = false;
                continue;
            }
            game = new Game();
        } while(isContinue);
    }
}
