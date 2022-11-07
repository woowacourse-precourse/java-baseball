package baseball.domain.game.service;

public class GameServiceImpl implements GameService{

    private final GameMessenger gameMessenger;
    private final GameValidator gameValidator;

    public GameServiceImpl(GameMessenger gameMessenger, GameValidator gameValidator) {
        this.gameMessenger = gameMessenger;
        this.gameValidator = gameValidator;
    }

    @Override
    public String requestInputNumber() {
        return gameMessenger.requestInputNumber();
    }

    @Override
    public void validateNumber(String number) {
        gameValidator.validateNumber(number);
    }
}
