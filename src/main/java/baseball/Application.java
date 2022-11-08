package baseball;

import baseball.game.Game;
import baseball.enums.system.UserAction;
import baseball.interaction.SystemUtil;

import baseball.message.GameMessage;

import baseball.message.SystemMessage;


public class Application {

    private static final SystemUtil systemUtil = SystemUtil.getInstance();

    public static void main(String[] args) {
        systemUtil.print(SystemMessage.START_PROGRAM);

        while (true) {
            Game.start();
            systemUtil.print(GameMessage.WIN_GAME);

            UserAction userAction = systemUtil.getUserInput();

            if (userAction == UserAction.STOP_PROGRAM) {
                break;
            }
        }

        systemUtil.print(SystemMessage.STOP_PROGRAM);
    }
}
