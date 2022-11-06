package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class User {
    private static final  Pattern compile= Pattern.compile("(([^1-9])\\2{0,})");
    public String getConsoleInput() {
        String input = Console.readLine();
        if(compile.matcher(input).find()) throw new IllegalArgumentException();
        return input;
    }
}
