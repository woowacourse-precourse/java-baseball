package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballUtil {
    public BaseballUtil() {
    }

    public int readLineInt() {
        String input = Console.readLine();
        int return_value;

        try{
            return_value = Integer.parseInt(input);
        }
        catch(Exception e) {
            throw new IllegalArgumentException();
        }

        return return_value;
    }

    public void printLine(String contents) {

    }
}
