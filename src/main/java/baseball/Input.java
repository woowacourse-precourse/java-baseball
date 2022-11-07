package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String scanUserPitches(){
        Output.requestPitching();
        return Console.readLine();
    }
    public static String scanWhetherNewGame(){
        Output.gameOverMessage();
        return Console.readLine();
    }
}
