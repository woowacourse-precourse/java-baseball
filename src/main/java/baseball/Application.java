package baseball;

import baseball.game.Game;
import baseball.system.util.SystemUtil;

import baseball.game.message.GameMessage;

import baseball.system.message.SystemMessage;


public class Application {

    private static final SystemUtil systemUtil = SystemUtil.getInstance();

    public static void main(String[] args) {
        systemUtil.print(SystemMessage.START_PROGRAM);

        while (true) {
            Game.start();
            systemUtil.print(GameMessage.WIN_GAME);

            Integer userAction = systemUtil.getUserInput();

            if (userAction == 2) {
                systemUtil.print(SystemMessage.STOP_PROGRAM);
                return;
            }
        }
    }
}
