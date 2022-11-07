package baseball.infrastructure.game;

import baseball.domain.game.service.GameMessenger;
import baseball.global.utils.console.Console;
import baseball.global.utils.message.TextMessage;

public class GameMessengerImpl implements GameMessenger {

    @Override
    public String requestInputNumber() {
        System.out.print(TextMessage.REQUEST_INPUT_NUMBER);
        return Console.readLine();
    }

    @Override
    public String requestContinueOrStop() {
        System.out.println(TextMessage.CONTINUE_OR_END);
        return Console.readLine();
    }
}
