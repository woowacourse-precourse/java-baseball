package baseball.view;

import baseball.message.ProgramMessage;

public class BaseballGameView {

    public void displayGameStart() {
        System.out.println(ProgramMessage.START_MESSAGE);
    }

    public void displayPleaseEnterNumber() {
        System.out.print(ProgramMessage.PLEASE_ENTER_NUMBER);
    }
}
