package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User {
    List<Integer> input;

    public User() {
        this.input = inputValue();
    }

    private List<Integer> inputValue() {
        input = new ArrayList<>();
        int inputNumbers = Integer.parseInt(Console.readLine());
        return input;
    }


}
