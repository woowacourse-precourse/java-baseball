package baseball.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserInput {
    public List<Integer> getInput() {
        String input = Console.readLine();
        List<Integer> inputList = new ArrayList<>();

        for (int idx = 0; idx < input.length(); idx++) {
            char c = input.charAt(idx);
            inputList.add(Character.getNumericValue(c));
        }

        return inputList;
    }
}
