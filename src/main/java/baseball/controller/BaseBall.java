package baseball.controller;

import baseball.domain.BaseBallGame;
import baseball.domain.Referee;
import baseball.dto.ScoresDTO;
import baseball.dto.SelectedNumberForRestartDTO;
import baseball.dto.UserNumbersDTO;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBall {
    private static final int RESTART_NUMBER = 1;
    
    public void start() {
        OutputView.printApplicationStartMessage();
        playBaseBallGame();
    }
    
    private void playBaseBallGame() {
        int selectedNumberForRestart = RESTART_NUMBER;
        
        while (isBaseBallGameRestart(selectedNumberForRestart)) {
            repeatBaseBallGame(new BaseBallGame());
            OutputView.baseBallGameEndMessagePrint();
            selectedNumberForRestart = inputNumberForRestart();
        }
    }
    
    private static boolean isBaseBallGameRestart(final int selectedNumberForRestart) {
        return selectedNumberForRestart == RESTART_NUMBER;
    }
    
    private void repeatBaseBallGame(final BaseBallGame baseBallGame) {
        boolean isBaseBallGameEnd = false;
        
        while (!isBaseBallGameEnd) {
            final Referee referee = playResult(baseBallGame);
            OutputView.printResult(new ScoresDTO(referee));
            isBaseBallGameEnd = referee.isEnd();
        }
    }
    
    private Referee playResult(final BaseBallGame baseBallGame) {
        return baseBallGame.play(inputUserBalls().getUserNumbers());
    }
    
    private UserNumbersDTO inputUserBalls() {
        return InputView.inputUserBalls();
    }
    
    private static int inputNumberForRestart() {
        SelectedNumberForRestartDTO selectedNumberForRestartDTO = InputView.inputNumberForRestart();
        return selectedNumberForRestartDTO.getSelectedNumberForRestart();
    }
}
