package baseball.inputoutput;

import java.io.IOException;
import java.util.LinkedHashSet;

import camp.nextstep.edu.missionutils.Console;


public class Inputting {

    public static LinkedHashSet<Character> input3LenNumber() throws IOException {
        LinkedHashSet<Character> inputNum = new LinkedHashSet<>();

        Outputting.printInputting();
        String inputString = Console.readLine();

        if (inputString.length() != 3) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < 3; i++) {
            inputNum.add(inputString.charAt(i));
        }

        return inputNum;
    }

    public static String inputEnd() {
        String inputString = Console.readLine();
        if ("1".equals(inputString) || "2".equals(inputString)) {
            return inputString;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
