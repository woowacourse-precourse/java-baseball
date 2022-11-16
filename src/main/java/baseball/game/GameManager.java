package baseball.game;

import baseball.game.utils.IntegerValidator;
import baseball.game.utils.StringConverter;
import camp.nextstep.edu.missionutils.Console;

import static baseball.game.config.constants.GameManagerMessage.ASK_GAME_RESTART;
import static baseball.game.config.constants.GameManagerMessage.GAME_START_MESSAGE;

public class GameManager {

    public static boolean checkRestartGame() {

        System.out.println(ASK_GAME_RESTART);
        int choice = StringConverter.toInteger(Console.readLine().strip());
        IntegerValidator.validateRestartChoice(choice);
        return checkChoice(choice);
    }

    private static boolean checkChoice(int choice) {
        if (choice == 1) {
            return true;
        }
        return false;
    }

    public void startGame() {

        System.out.println(GAME_START_MESSAGE);

        boolean token = true;
        while (token) {
            Game game = new Game();
            game.run();

            token = checkRestartGame();
        }
    }
}
