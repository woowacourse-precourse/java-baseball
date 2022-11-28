package baseball.view;

import baseball.util.InputViewMessage;
import baseball.valid.InputValidator;
import baseball.valid.PlayerNumberValidator;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public enum InputView {

    INSTANCE;

    public static String readPlayerNumber() {
        System.out.print(InputViewMessage.READ_PLAYER_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public static String readGameCommand() {
        System.out.println(InputViewMessage.READ_GAME_COMMAND_MESSAGE);
        return Console.readLine();
    }
}
