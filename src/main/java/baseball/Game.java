package baseball;

import java.util.ArrayList;
import java.util.List;

import static baseball.View.*;

public class Game {
    private static Computer computer = new Computer();
    public static User user = new User();

    public static void start() {
        user.register(computer);
        printMessage(Message.NUMBER_BASEBALL_GAME_START);
        while (true) {
            computer.makeRandomNumber();

            startUnitGame();

            printMessage(Message.NUMBER_BASEBALL_GAME_IS_RESTART);
            String userInput = user.getConsoleInput();

            if (GameStatus.validStatus(userInput)&&!GameStatus.isYes(userInput)) {
                return;
            }
        }
    }

    private static void startUnitGame() {
        while (true) {
            printMessage(Message.INPUT_NUMBER);

            getUserInput();

            HintReader hintReader = new HintReader(user.compareToComputer());

            String hinString = hintReader.toHintString();
            print(hinString);

            if (hintReader.isThreeStrike()) {
                printMessage(Message.END_NUMBER_BASEBALL_GAME);
                return;
            }
        }
    }

    private static void getUserInput() {
        user.makeBaseBallNumber();
        user.printBaseBallNumber();
    }
}
