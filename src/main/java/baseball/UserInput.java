package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserInput {
    public List<Integer> getInput() {
        String input = Console.readLine();
        List<Integer> inputList = new ArrayList<>();

        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }

        for (int idx = 0; idx < input.length(); idx++) {
            char c = input.charAt(idx);
            int num = Character.getNumericValue(c);

            if (num <= 0 || inputList.contains(num) || num >= 10) {
                throw new IllegalArgumentException();
            }

            inputList.add(num);
        }

        return inputList;
    }

    public boolean isStart() {
        String input = Console.readLine();

        if (input.equals("1")) {
            return true;
        } else if (input.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException();
    }
}
