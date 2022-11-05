package baseball.view;

import static baseball.view.PrintMessage.*;

public class Instruction {
    public void printStart() {
        System.out.println(GAME_START.getMessage());
    }

    public void printInputData() {
        System.out.print(INPUT_DATA.getMessage());
    }

    public void printRunCode() {
        System.out.println(RUN_CODE.getMessage());
    }
}
