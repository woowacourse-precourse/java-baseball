package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Input {

    public static final int MAXIMUM_NUMBER = 9;
    public static final int MINIMUM_NUMBER = 1;
    public static final int DIGITS = 3;

    public static String numbers() {
        return Console.readLine();
    }
}
