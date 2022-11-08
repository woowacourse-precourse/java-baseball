package baseball.domain;

import baseball.view.InputView;
import baseball.view.OutputView;

public class Game {
    private int strikeCount;
    private int ballCount;
    private final String RESTART_VALUE = "1";
    public void play() {
        Computer computer = new Computer();
        User user = new User();
        Score score = new Score();
        strikeCount = 0;
        ballCount = 0;
        computer.setCorrectBaseballNumbersRandom();

        do{
            user.inputBaseballNumbers();
            score.countBallAndStrike(user.getBaseballNumbers(), computer.getCorrectBaseballNumbers());
            score.print();

        } while(!score.isEqualTo(user.getBaseballNumbers(), computer.getCorrectBaseballNumbers()));
        OutputView.printEndGame();
        user.inputRestartOrStop();
        if(user.getRestartOrStop() == 1){
            play();
        }
    }

}
