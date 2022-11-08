package baseball;

import static baseball.View.*;

public class Game {
    private static Computer computer = new Computer();
    public static User user = new User();

    public static void start() {
        user.register(computer);
        printMessage(Message.NUMBER_BASEBALL_GAME_START);
        while (true) {
            computer.genRandomNumber();

            startGameToUserForComputer();

            printMessage(Message.NUMBER_BASEBALL_GAME_IS_RESTART);

            GameRestartStatus gameStatus = GameRestartStatus.of(user.getConsoleInput());
            gameStatus.print();

            if (!gameStatus.isYes()) {
                return;
            }
        }
    }

    private static void startGameToUserForComputer() {
        while (true) {
            printMessage(Message.INPUT_NUMBER);

            user.mappingUserInputToBaseBallNumber();
            print(user.baseBallNumberString());

            HintReader hintReader = new HintReader(user.compareToComputer());

            print(hintReader.toHintString());

            if (hintReader.isThreeStrike()) {
                printMessage(Message.END_NUMBER_BASEBALL_GAME);
                return;
            }
        }
    }
}
