package baseball;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInput {

    private ConsoleInput(){
    }

    public static String inputWithMessage(String message){
        System.out.print(message);
        return Console.readLine();
    }
}
