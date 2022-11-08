package baseball;

public class Assembler {

    private static GameController gameController;

    public void createAndWire() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        InputController inputController = new InputControllerImp();
        HintCalculator hintCalculator = new HintCalculatorImp();
        View view = new ConsoleView(inputController);
        gameController = new GameController(numberGenerator, hintCalculator, view);
    }

    public GameController getGameController() {
        return gameController;
    }
}
