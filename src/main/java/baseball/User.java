package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class User {


    public List userInput() {
        try {
            String str = Console.readLine();
        } catch (IllegalArgumentException e) {
        }
        return StringToNumberList(str);
    }
}