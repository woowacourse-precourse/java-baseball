package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User {
    private final List<Integer> number = new ArrayList<>();

    public void inputNumber() {
        String inputValue = Console.readLine();
        setNumber(inputValue);
    }

    private void setNumber(String inputValue) {
        for (String digit : inputValue.split("")) {
            number.add(Integer.valueOf((digit)));
        }
    }

    public List<Integer> getNumber() {
        return number;
    }
}
