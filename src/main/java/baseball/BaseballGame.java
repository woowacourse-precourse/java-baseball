package baseball;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.domain.Score;
import baseball.utils.BallNumberComparer;
import baseball.utils.OutputGenerator;

public class BaseballGame {
    public static final int INPUT_SIZE = 3;
    private final Player player;
    private final Computer computer;
    private final OutputGenerator outputGenerator;
    private final BallNumberComparer ballNumberComparer;

    public BaseballGame(Player player, Computer computer, OutputGenerator outputGenerator, BallNumberComparer ballNumberComparer) {
        this.player = player;
        this.computer = computer;
        this.outputGenerator = outputGenerator;
        this.ballNumberComparer = ballNumberComparer;
    }

    public void run() throws IllegalArgumentException {
        runInitPhase();
        while (true) {
            Score score = runOneRound();
            if (isGameEnd(score)) {
                break;
            }
        }
    }

    private void runInitPhase() {
        outputGenerator.printWelcome();
        computer.generateComputerNumber();
    }

    private Score runOneRound() {
        outputGenerator.printRequestBallNumber();
        player.readBallNumber();

        Score score = ballNumberComparer.calculateScore(player.getBallNumber(), computer.getBallNumber());
        outputGenerator.printScore(score);
        return score;
    }

    private boolean runEndPhase() {
        outputGenerator.printGameEnd();
        boolean ret = false;
        if (player.readWeatherReGame()) {
            computer.generateComputerNumber();
        } else {
            ret = true;
        }
        return ret;
    }

    private boolean isGameEnd(Score score) {
        boolean ret = false;
        if (score.getStrike() == INPUT_SIZE) {
            ret = runEndPhase();
        }
        return ret;
    }
}
