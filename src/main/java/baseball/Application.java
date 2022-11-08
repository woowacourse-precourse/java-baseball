package baseball;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.utils.BallNumberComparer;
import baseball.utils.InputValidator;
import baseball.utils.OutputGenerator;

public class Application {
    public static void main(String[] args) {
        Player player = new Player(new InputValidator());
        Computer computer = new Computer();
        OutputGenerator outputGenerator = new OutputGenerator();
        BallNumberComparer ballNumberComparer = new BallNumberComparer();
        BaseballGame baseballGame = new BaseballGame(player, computer, outputGenerator, ballNumberComparer);
        baseballGame.run();
    }
}