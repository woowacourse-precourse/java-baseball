package baseball.utils;

import static baseball.utils.BaseballConstants.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInput {

    public static String input(){
        System.out.print(WRITE_NUMBER);
        String userInput = readLine();

        NumberChecker.checkUserInput(userInput);

        return userInput;
    }

    public static String endInput(){
        System.out.print(RESTART);
        String userInput = readLine();

        NumberChecker.isOneOrTwo(userInput);

        return userInput;
    }
}
