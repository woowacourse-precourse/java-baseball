package baseball.infrastructure.game;

import baseball.domain.game.service.GameMessenger;
import baseball.global.utils.console.Console;
import baseball.global.utils.message.TextMessage;

public class GameMessengerImpl implements GameMessenger {
    @Override
    public String requestInputNumber() {
        printNotLineBreakMessage(TextMessage.REQUEST_INPUT_NUMBER);
        return Console.readLine();
    }

    private void printNotLineBreakMessage(String message) {
        System.out.print(message);
    }
}
