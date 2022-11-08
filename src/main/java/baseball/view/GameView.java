package baseball.view;

import baseball.domain.game.Result;
import baseball.domain.player.Player;
import baseball.utils.Validator;
import camp.nextstep.edu.missionutils.Console;

import static baseball.utils.Constants.GAME_RESTART;
import static baseball.utils.Messages.*;

public class GameView {
    public void startGame() {
        System.out.println(START_MESSAGE);
    }

    public void receivePlayerInput(Player player) {
        System.out.print(INPUT_MESSAGE);
        player.setInputNumbers(Console.readLine());
    }

    public void printResult(Result gameResult) {
        System.out.println(gameResult.getResult());
    }

    public void printSuccessAndRestart() {
        System.out.println(SUCCESS_MESSAGE);
        System.out.println(RESTART_MESSAGE);
    }

    public boolean isRestart() {
        String input = Console.readLine();
        Validator.validateRestartInput(input);
        return input.equals(GAME_RESTART);
    }
}
