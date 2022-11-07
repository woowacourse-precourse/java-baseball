package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class PlayerNum implements Number {


    @Override
    public void verifyNumber(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 9) {
                throw new IllegalArgumentException();
            } else if (numbers.size() != 3 || numbers.size() != numbers.stream().distinct().count()) {
                throw new IllegalArgumentException();
            }
        }
    }

    @Override
    public List<Integer> createNumber() {
        List<Integer> numbers;
        System.out.print(GameComment.WELCOME_MSG);
        String input = Console.readLine();
        verifyInput(input);
        numbers = convertInput(input);
        verifyNumber(numbers);
        return numbers;
    }

    private void verifyInput(String input) {
        char array[] = input.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (Character.isDigit(array[i]) == true) {
                continue;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    private List<Integer> convertInput(String input) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(Integer.parseInt(input) / 100);
        numbers.add((Integer.parseInt(input) % 100) / 10);
        numbers.add((Integer.parseInt(input) % 100) % 10);
        return numbers;
    }

}
