package baseball.controller;

import baseball.domain.BaseBallGame;
import baseball.domain.Referee;
import baseball.dto.RefereeDTO;
import baseball.dto.UserNumbersDTO;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBall {
    public void start() {
        OutputView.printApplicationStartMessage();
        playBaseBallGame();
    }
    
    private void playBaseBallGame() {
        repeatBaseBallGame(new BaseBallGame());
        OutputView.baseBallGameEndMessagePrint();
    }
    
    private void repeatBaseBallGame(final BaseBallGame baseBallGame) {
        boolean isEnd = false;
        while(!isEnd) {
            final Referee referee = playResult(baseBallGame);
            OutputView.printResult(new RefereeDTO(referee));
            isEnd = referee.isEnd();
        }
    }
    
    private Referee playResult(final BaseBallGame baseBallGame) {
        return baseBallGame.play(inputUserBalls().getUserNumbers());
    }
    
    private UserNumbersDTO inputUserBalls() {
        return InputView.inputUserBalls();
    }
}
