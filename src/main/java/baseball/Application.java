package baseball;

import baseball.gamePlay.GamePlay;
import baseball.strategy.NumberProducingStrategy;
import baseball.strategy.RandomNumberProducingStrategy;

public class Application {
    public static void main(String[] args) {
        NumberProducingStrategy numberProducingStrategy = new RandomNumberProducingStrategy();
        GamePlay.play(numberProducingStrategy);
    }
}
