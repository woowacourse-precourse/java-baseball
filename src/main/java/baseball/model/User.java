package baseball.model;

import baseball.utility.Utility;
import camp.nextstep.edu.missionutils.Console;

public class User {
    public int ask(){
        String input = Console.readLine();
        Utility.checkInputException(input);
        return Integer.valueOf(input);
    }
}
