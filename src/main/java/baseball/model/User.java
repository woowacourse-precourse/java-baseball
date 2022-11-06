package baseball.model;

import camp.nextstep.edu.missionutils.Console;

public class User {
    public int ask(){
        String input = Console.readLine();
        return Integer.valueOf(input);
    }
}
