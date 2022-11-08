package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Input {

    public static List<Integer> getInput(){
        Output.getNumber();
        String playerAnswer = Console.readLine();
        return Validator.convertor(playerAnswer);
    }

    public static int getRestart(){
        String gMode = Console.readLine();
        return Integer.parseInt(gMode);
    }
}
