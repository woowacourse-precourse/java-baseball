package baseball.service;

import baseball.domain.Game;
import baseball.utils.RandomNumber;
import java.util.List;

public class Service {
    Game game;

    public void setGame() {
        List<Integer> randomNumberList = RandomNumber.generateUnduplicatedThreeNumbers();
        this.game = new Game(randomNumberList);
    }
}
