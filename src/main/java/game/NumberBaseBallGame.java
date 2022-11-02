package game;

import validator.Validator;
import view.Input;
import view.Output;

public class NumberBaseBallGame {

    public static void run() {
        while (true) {
            // todo 게임 관련 메인 메서드 실행
            String input = Input.scanStartOrEndNumber();
            try {
                Validator.checkStartOrEndInput(input);
            } catch (IllegalArgumentException e) {
                Output.printStartOrEndInputError(e);
                break;
            }
        }
    }
}
