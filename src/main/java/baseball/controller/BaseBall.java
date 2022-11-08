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
            playBaseBallGameOnce();
            selectedNumberForRestart = selectedNumberForRestart();
        }
    }
    
    private static boolean isBaseBallGameRestart(final int selectedNumberForRestart) {
        return selectedNumberForRestart == RESTART_NUMBER;
    }
    
    private void playBaseBallGameOnce() {
        compareBallsRepeatedly(new BaseBallGame());
        printBaseBallGameEndMessage();
    }
    
    private void compareBallsRepeatedly(final BaseBallGame baseBallGame) {
        boolean isBaseBallGameEnd = false;
        
        while (!isBaseBallGameEnd) {
            final Referee referee = compareBallsOnce(baseBallGame);
            isBaseBallGameEnd = isBaseBallGameEnd(referee);
        }
    }
    
    private Referee compareBallsOnce(final BaseBallGame baseBallGame) {
        final Referee referee = playResult(baseBallGame);
        printResult(referee);
        return referee;
    }
    
    private Referee playResult(final BaseBallGame baseBallGame) {
        return baseBallGame.play(userNumbers());
    }
    
    private String userNumbers() {
        final UserNumbersDTO userNumbersDTO = inputUserBalls();
        return userNumbersDTO.getUserNumbers();
    }
    
    private UserNumbersDTO inputUserBalls() {
        return InputView.inputUserBalls();
    }
    
    private void printResult(final Referee referee) {
        OutputView.printResult(new ScoresDTO(referee));
    }
    
    private boolean isBaseBallGameEnd(final Referee referee) {
        return referee.isBaseBallGameEnd();
    }
    
    private void printBaseBallGameEndMessage() {
        OutputView.baseBallGameEndMessagePrint();
    }
    
    private int selectedNumberForRestart() {
        SelectedNumberForRestartDTO selectedNumberForRestartDTO = inputNumberForRestart();
        return selectedNumberForRestartDTO.getSelectedNumberForRestart();
    }
    
    private SelectedNumberForRestartDTO inputNumberForRestart() {
        return InputView.inputNumberForRestart();
    }
}
