package game.number;

import camp.nextstep.edu.missionutils.Console;
import game.util.Validate;
import java.util.ArrayList;
import java.util.List;

public class InputNumbers extends ThreeNumbers {
    List<Integer> inputNumbers = new ArrayList<>();

    public InputNumbers() throws IllegalArgumentException {
        createThreeNumbers();
    }

    @Override
    void createThreeNumbers() throws IllegalArgumentException {
        readNumbers();
    }

    void readNumbers() throws IllegalArgumentException {
        String input = Console.readLine();
        Validate.InputNumbers(input);
        toThreeNumbers(input);
    }

    void toThreeNumbers(String input) {
        String[] inputArr = input.split("");
        for (String strNumber : inputArr) {
            inputNumbers.add(toInt(strNumber));
        }
    }

    int toInt(String strNumber) {
        return Integer.parseInt(strNumber);
    }

    public int getNumber(int index) {
        return inputNumbers.get(index);
    }
}
