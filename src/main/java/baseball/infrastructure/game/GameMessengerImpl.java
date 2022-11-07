package baseball.infrastructure.game;

import baseball.domain.hint.Hint;
import baseball.domain.game.service.GameMessenger;
import baseball.domain.hint.HintMessenger;
import baseball.global.utils.console.Console;
import baseball.global.utils.message.ErrorMessage;
import baseball.global.utils.message.TextMessage;

import java.util.List;

public class GameMessengerImpl implements GameMessenger {

    private final List<HintMessenger> hintMessengers;

    public GameMessengerImpl(List<HintMessenger> hintMessengers) {
        this.hintMessengers = hintMessengers;
    }

    @Override
    public String requestInputNumber() {
        System.out.print(TextMessage.REQUEST_INPUT_NUMBER);
        return Console.readLine();
    }

    @Override
    public void sendHint(Hint hint) {
        final HintMessenger hintMessenger = routingHintMessenger(hint);
        hintMessenger.printMessage(hint);
    }

    @Override
    public String requestContinueOrStop() {
        System.out.println(TextMessage.CONTINUE_OR_END);
        return Console.readLine();
    }

    private HintMessenger routingHintMessenger(Hint hint) {
        return hintMessengers.stream()
                .filter(hintMessenger -> hintMessenger.support(hint))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_HINT));
    }
}
