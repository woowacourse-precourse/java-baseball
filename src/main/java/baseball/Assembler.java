package baseball;

public class Assembler {

    private static GameController gameController;
    private static View view;

    public void createAndWire() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        InputController inputController = new InputControllerImp();
        HintCalculator hintCalculator = new HintCalculatorImp();
        view = new ConsoleView(inputController);
        gameController = new GameController(numberGenerator, hintCalculator, view);
    }
}
