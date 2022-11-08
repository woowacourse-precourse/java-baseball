package baseball;

import baseball.computer.Computer;
import baseball.game.Game;
import baseball.program.Program;
import baseball.utils.GameResultCalculator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Program.init();
        OutputView.displayGameStartMessage();
        programStart();
    }

    private static void programStart() {
        Computer.init();

        while (!Program.isProgramEnd()) {
            InputView.displayInputNumberMessage();
            Game game = GameResultCalculator.calculateStrikeAndBallCount(InputView.getUserInputNumbers());
            OutputView.displayGameResult(game);

            if (game.isGameOver()) {
                OutputView.displayGameOverMessage();
                InputView.displayInputGameStateCommandMessage();
                Program.changeStatus(InputView.getUserInputCommand());
                Computer.reInitIfProgramContinue();
            }
        }
    }
}
