package baseball;

import camp.nextstep.edu.missionutils.Console;

public class TextIO {
    public static String In(boolean isSimple){
        String input = Console.readLine();
        if(isSimple)
            return input;
        if(validate(input))
            return input;
        else
            throw new IllegalArgumentException("invalid input");
    }

}
