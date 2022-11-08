package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static String getInput() {
        String inputNumber;
        inputNumber = Console.readLine();
        return inputNumber;
    }

    public static int getStartFlag() {
        int startFlag;
        startFlag= Integer.parseInt(Console.readLine());
        return startFlag;
    }
}
