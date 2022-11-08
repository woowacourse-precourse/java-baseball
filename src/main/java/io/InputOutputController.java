package io;

public class InputOutputController {

    private static int outputType;
    private static int inputType;
    private static final int INPUT_CONSOLE_MODE = 1;
    private static final int OUTPUT_CONSOLE_MODE = 1;

    public InputOutputController(Integer InputType, Integer OutputType, Integer inputSize) {
        if (OutputType == OUTPUT_CONSOLE_MODE) {
            this.outputType = OUTPUT_CONSOLE_MODE;
            ScreenOutput screen = new ScreenOutput(inputSize);
        }
        if (InputType == INPUT_CONSOLE_MODE) {
            this.inputType = INPUT_CONSOLE_MODE;
            KeyboardInput user = new KeyboardInput(inputSize);
        }
    }

    public static void outputStartMessage() {
        if (outputType == OUTPUT_CONSOLE_MODE) {
            ScreenOutput.printGameStart();
        }
    }

    public static void outputInputMessage() {
        if (outputType == OUTPUT_CONSOLE_MODE) {
            ScreenOutput.printInputNumber();
        }
    }

    public static void outputEndingMessage() {
        if (outputType == OUTPUT_CONSOLE_MODE) {
            ScreenOutput.printEndingMessage();
        }
    }

    public static String outputResultMessage(String calculatedResult) {
        if (outputType == OUTPUT_CONSOLE_MODE) {
            return ScreenOutput.printCalculateResult(calculatedResult);
        }
        return "";
    }

    public static String inputGet(int playMode) {
        if (inputType == INPUT_CONSOLE_MODE) {
            return KeyboardInput.inputValue(playMode);
        }
        return "";
    }
}
