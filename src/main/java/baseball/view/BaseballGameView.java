package baseball.view;

import baseball.message.ProgramMessage;

import static baseball.util.ProcessCode.*;

public class BaseballGameView {

    public void displayGameStart() {
        System.out.println(ProgramMessage.START_MESSAGE);
    }

    public void displayPleaseEnterNumber() {
        System.out.print(ProgramMessage.PLEASE_ENTER_NUMBER);
    }

    public void displayAskReStartGame() {
        System.out.println(String.format(ProgramMessage.ASK_RESTART_GAME, Integer.parseInt(RESTART.getValue()), Integer.parseInt(FINISH.getValue())));
    }
}
