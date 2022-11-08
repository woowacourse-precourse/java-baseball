package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String scanUserPitches(){
        Output.printPitchingRequest();
        return Console.readLine();
    }
    public static String scanWhetherNewGame(){
        Output.printGameOverMessage();
        return Console.readLine();
    }
}
