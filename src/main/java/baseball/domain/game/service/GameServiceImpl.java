package baseball.domain.game.service;

import baseball.domain.hint.Hint;

public class GameServiceImpl implements GameService{

    private final GameMessenger gameMessenger;
    private final GameValidator gameValidator;
    private final GameReferee gameReferee;

    public GameServiceImpl(GameMessenger gameMessenger, GameValidator gameValidator, GameReferee gameReferee) {
        this.gameMessenger = gameMessenger;
        this.gameValidator = gameValidator;
        this.gameReferee = gameReferee;
    }

    @Override
    public String requestInputNumber() {
        return gameMessenger.requestInputNumber();
    }

    @Override
    public void validateNumber(String number) {
        gameValidator.validateNumber(number);
    }

    @Override
    public boolean judgeIsAnswer(Hint hint) {
        return gameReferee.judgeIsAnswer(hint);
    }

    @Override
    public boolean endOrRestart() {
        final String response = gameMessenger.requestContinueOrStop();
        gameValidator.validateContinueOrStop(response);
        return gameReferee.judgeContinueOrStop(response);
    }
}
