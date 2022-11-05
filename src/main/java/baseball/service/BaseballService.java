package baseball.service;

import baseball.domain.Computer;
import baseball.domain.Game;
import baseball.domain.User;
import baseball.utils.Constant;

public class BaseballService {
    private final User user;
    private final Computer computer;
    private final Game game;

    public BaseballService() {
        user = new User();
        computer = new Computer();
        game = new Game();
    }

    public boolean getGameStatus(){
        return game.getStatus();
    }
}
