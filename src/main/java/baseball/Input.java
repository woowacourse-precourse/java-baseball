package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String userPitching(){
        Output.requestPitching();
        return Console.readLine();
    }
    public static String whetherNewGame(){
        Output.gameOverMessage();
        return Console.readLine();
    }
}
