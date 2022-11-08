package baseball;

import baseball.hint.HintCalculator;
import baseball.hint.HintCalculatorImp;
import baseball.input.InputController;
import baseball.input.InputControllerImp;
import baseball.view.ConsoleView;
import baseball.view.View;

public class Assembler {

    private static GameController gameController;

    public void createAndWire() {
        InputController inputController = new InputControllerImp();
        HintCalculator hintCalculator = new HintCalculatorImp();
        View view = new ConsoleView(inputController);
        gameController = new GameController(hintCalculator, view);
    }

    public GameController getGameController() {
        return gameController;
    }
}
