package IOController;

import java.security.Key;

public class InputOutputController {

    private KeyboardInput user;
    private ScreenOutput screen;
    private static int outputType;
    private static int inputType;
    private static int inputSize;
    private static final int INPUT_CONSOLEMODE = 1;
    private static final int OUTPUT_CONSOLEMODE = 1;


    public InputOutputController(Integer InputType, Integer OutputType, Integer inputSize) {
        //나중엔 type 에 따라 어떤 버전의 input, output 을 사용할 지 정하자 (enum 활용?)
        this.inputSize= inputSize;
        if (OutputType == OUTPUT_CONSOLEMODE) {
            this.outputType = OUTPUT_CONSOLEMODE;
            screen = new ScreenOutput();
        }
        if (InputType == INPUT_CONSOLEMODE) {
            this.inputType = INPUT_CONSOLEMODE;
            user= new KeyboardInput(inputSize);
        }
    }

    public static void outputStartMessage() {
        if (outputType == OUTPUT_CONSOLEMODE) {
            ScreenOutput.printGameStart();
        }
        //콘솔이 아닌 다른 모드가 생성되면 여기에 추가만 해준다는 느낌으로
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
