package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Input {

    public static String numbers() {
        Print.inputNumbers();
        return Console.readLine();
    }
}
