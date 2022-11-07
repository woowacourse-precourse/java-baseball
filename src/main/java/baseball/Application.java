package baseball;

import baseball.gamePlay.GamePlay;
import baseball.strategy.NumberProducingStrategy;
import baseball.strategy.RandomNumberProducingStrategy;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        NumberProducingStrategy numberProducingStrategy = new RandomNumberProducingStrategy();
        GamePlay.play(numberProducingStrategy);
    }
}
