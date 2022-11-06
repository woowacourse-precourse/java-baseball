
package baseball.view;

import baseball.exception.InputDuplicateException;
import baseball.exception.InputNotNumberException;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InputView {

    public int inputNumber() {
        try {
            String number = Console.readLine();
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new InputNotNumberException();
        }
    }

    public List<Integer> inputNumbers() { // 중복여부, 자릿수 여부까지
        try {
            String inputItems = Console.readLine();
            List<Integer> numbers = new ArrayList<>();

            for (char item : inputItems.toCharArray()) {
                numbers.add(Integer.parseInt(Character.toString(item)));
            }

            validateInputDuplicate(numbers);

            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateInputDuplicate(List<Integer> inputs) {
        System.out.println(" validate ");
        for(Integer input : inputs){
            if(Collections.frequency(inputs,input) > 1){
                throw new InputDuplicateException();
            }
        }
    }
}