package baseball;

import baseball.exception.InputException;
import baseball.service.ComputerService;
import baseball.service.PlayerService;
import baseball.view.InstructionView;

import java.util.List;

public class Game {
    private static final int RESTART = 1;
    InstructionView instructionView = new InstructionView();
    PlayerService playerService = new PlayerService();
    ComputerService computerService = new ComputerService();
    InputException inputException = new InputException();
    private int runCode;

    public void startGame() {
        instructionView.printStart();
        runGame();
    }

    public void runGame() {
        computerService.initComputer();
        List<Integer> computerNumbers = computerService.getComputer().getNumbers();
//        do {
//            String inputNumbers = instructionView.printInputNumbers();
//            playerService.inputNumbersToPlayer(inputNumbers);
//            List<Integer> playerNumbers = playerService.getPlayer().getNumbers();
//        } while () // 성공 확인하고 탈출
//        if (inputRunCode() == RESTART) {
//            runGame();
//        }
    }

    public int inputRunCode() {
        String runCode = instructionView.printInputCode();
        checkRunCodeException(runCode);
        return Integer.parseInt(runCode);
    }

    private void checkRunCodeException(String runCode) {
        inputException.isInvalidCodeSize(runCode);
        inputException.isDigitException(runCode);
        inputException.isInvalidCode(Integer.parseInt(runCode));
    }
}