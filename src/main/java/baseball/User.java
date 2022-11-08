package baseball;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {
    public List<Integer> getInputNumbers() {
        List<String> userInput = Arrays.asList(readLine().split(""));

        if(!isValidInput(userInput)) {
            throw new IllegalArgumentException();
        };

        List<Integer> inputNumbers = userInput.stream()
                .map(number -> Integer.parseInt(number))
                .collect(Collectors.toList());

        if(!isValidNumbers(inputNumbers)) {
            throw new IllegalArgumentException();
        }

        return inputNumbers;
    }

    public boolean isValidInput(List<String> input) {
        try {
            input.stream().forEach(element -> Integer.parseInt(element));
            return true;
        } catch (NumberFormatException e) {
//            e.printStackTrace();
            return false;
        }
    }

    public boolean isValidNumbers(List<Integer> numbers) {
        if(numbers.size() != 3)
            return false;
        for(Integer number: numbers) {
            int overlapCnt = Collections.frequency(numbers, number);
            if(overlapCnt > 1)
                return false;
            if(number < 1 || number > 9)
                return false;
        }
        return true;
    }
}
