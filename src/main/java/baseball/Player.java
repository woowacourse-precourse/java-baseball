package baseball;

import baseball.ball.Balls;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class Player {
    private Balls playerBalls;

    private List<String> inputPlayerNumber(){
        OutputView.requestInputNumber();
        String playerCandidateNumber=InputView.inputPlayerNumber();
        return Arrays.asList(playerCandidateNumber.split(""));
    }
}
