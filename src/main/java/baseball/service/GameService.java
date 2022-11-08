package baseball.service;

import baseball.domain.GameDomain;
import baseball.util.RandomNumberMaker;

public class GameService {
    int size;
    GameDomain game;

    public void setGame(int size, int start, int end) {
        this.size = size;
        game = new GameDomain(RandomNumberMaker.getRandomNumbers(size, start, end));
    }
}
