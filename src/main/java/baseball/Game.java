package baseball;

import baseball.exception.InputException;
import baseball.service.ComputerService;
import baseball.service.PlayerService;
import baseball.service.ScoreBoardService;
import baseball.view.InstructionView;
import baseball.view.ResultView;

import java.util.List;

public class Game {
    private static final int RESTART = 1;
    ComputerService computerService = new ComputerService();
    InputException inputException = new InputException();
    InstructionView instructionView = new InstructionView();
    PlayerService playerService = new PlayerService();
    ResultView resultView = new ResultView();
    ScoreBoardService scoreBoardService = new ScoreBoardService();

    private void checkRunCodeException(String runCode) {
        inputException.isInvalidCodeSize(runCode);
        inputException.isDigitException(runCode);
        inputException.isInvalidCode(Integer.parseInt(runCode));
    }

    private int inputRunCode() {
        String runCode = instructionView.printInputCode();
        checkRunCodeException(runCode);
        return Integer.parseInt(runCode);
    }

    private void printResult() {
        if (scoreBoardService.isBallAndStrike()) {
            resultView.printBall(scoreBoardService.getScoreBoard().getBall());
            resultView.printStrike(scoreBoardService.getScoreBoard().getStrike());
        } else if (scoreBoardService.isBall()) {
            resultView.printBall(scoreBoardService.getScoreBoard().getBall());
            System.out.println("");
        } else if (scoreBoardService.isStrike()) {
            resultView.printStrike(scoreBoardService.getScoreBoard().getStrike());
        } else if (scoreBoardService.isNothing()) {
            resultView.printNothing();
        }
    }

    private void runGame() {
        computerService.initComputer();
        List<Integer> computerNumbers = computerService.getComputer().getNumbers();
        while (!scoreBoardService.isThreeStrike()) {
            String inputNumbers = instructionView.printInputNumbers();
            playerService.inputNumbersToPlayer(inputNumbers);
            List<Integer> playerNumbers = playerService.getPlayer().getNumbers();
            scoreBoardService.setScoreBoard(computerNumbers, playerNumbers);
            printResult();
        }
        resultView.printSuccess();
        if (inputRunCode() == RESTART) {
            scoreBoardService.getScoreBoard().setThreeStrike(false);
            runGame();
        }
    }

    public void startGame() {
        instructionView.printStart();
        runGame();
    }
}