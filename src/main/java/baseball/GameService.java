package baseball;

import baseball.domain.Game;
import baseball.utils.RandomUtils;

public class GameService {
    int size;
    Game game;

    public void setGame(int size, int start, int end) {
        this.size = size;
        game = new Game(RandomUtils.getRandomNumbers(size, start, end));
    }
}
