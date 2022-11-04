
package baseball.view;

import baseball.exception.InputNotNumberException;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    public int inputNumber(){
        try {
            String number = Console.readLine();
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new InputNotNumberException();
        }
    }

    public List<Integer> inputNumbers(){
        try {
            String inputItems = Console.readLine();
            List<Integer> numbers = new ArrayList<>();
            for (char item : inputItems.toCharArray()) {
                numbers.add(Integer.parseInt(Character.toString(item)));
            }
            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}