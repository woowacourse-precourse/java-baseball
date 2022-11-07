package baseball.domain.hint.service;

import baseball.domain.ball.Balls;
import baseball.domain.hint.Hint;
import baseball.global.utils.message.ErrorMessage;

import java.util.List;

public class HintServiceImpl implements HintService {

    private final HintCreator hintCreator;
    private final List<HintMessenger> hintMessengers;

    public HintServiceImpl(HintCreator hintCreator, List<HintMessenger> hintMessengers) {
        this.hintCreator = hintCreator;
        this.hintMessengers = hintMessengers;
    }


    @Override
    public Hint createHint(Balls playerBall, Balls answerBall) {
        return hintCreator.createHint(playerBall, answerBall);
    }

    @Override
    public void sendHint(Hint hint) {
        final HintMessenger hintMessenger = routingHintMessenger(hint);
        hintMessenger.printMessage(hint);
    }


    private HintMessenger routingHintMessenger(Hint hint) {
        return hintMessengers.stream()
                .filter(hintMessenger -> hintMessenger.support(hint))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_HINT));
    }
}
