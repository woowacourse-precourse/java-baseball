package IOController;

public class InputOutputController {

    private static int outputType;
    private static int inputType;
    private static final int INPUT_CONSOLEMODE = 1;
    private static final int OUTPUT_CONSOLEMODE = 1;

    public InputOutputController(Integer InputType, Integer OutputType, Integer inputSize) {
        if (OutputType == OUTPUT_CONSOLEMODE) {
            this.outputType = OUTPUT_CONSOLEMODE;
            ScreenOutput screen = new ScreenOutput(inputSize);
        }
        if (InputType == INPUT_CONSOLEMODE) {
            this.inputType = INPUT_CONSOLEMODE;
            KeyboardInput user = new KeyboardInput(inputSize);
        }
    }

    public static void outputStartMessage() {
        if (outputType == OUTPUT_CONSOLEMODE) {
            ScreenOutput.printGameStart();
        }
    }

    public static void outputInputMessage() {
        if (outputType == OUTPUT_CONSOLEMODE) {
            ScreenOutput.printInputNumber();
        }
    }

    public static void outputEndingMessage() {
        if (outputType == OUTPUT_CONSOLEMODE) {
            ScreenOutput.printEndingMessage();
        }
    }

    public static String outputResultMessage(String calculatedResult) {
        if (outputType == OUTPUT_CONSOLEMODE) {
            return ScreenOutput.printCalculateResult(calculatedResult);
        }
        return "";
    }

    public static String inputGet(int playMode) {
        if (inputType == INPUT_CONSOLEMODE) {
            return KeyboardInput.inputValue(playMode);
        }
        return "";
    }
}
