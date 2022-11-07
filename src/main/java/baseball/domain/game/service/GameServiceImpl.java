package baseball.domain.game.service;

public class GameServiceImpl implements GameService{

    private final GameMessenger gameMessenger;

    public GameServiceImpl(GameMessenger gameMessenger) {
        this.gameMessenger = gameMessenger;
    }

    @Override
    public String requestInputNumber() {
        return gameMessenger.requestInputNumber();
    }
}
