package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.ArrayList;

public class User {

    public void pickNumbers(){
        String numbers = Console.readLine();

        validateInput(numbers);
    }

    private void validateInput(String input){
        validateLength(input);
        validateType(input);
        validateUnique(input);
    }

    private void validateLength(String input){
        if (input.length() != 3){
            throw new IllegalArgumentException();
        }
    }

    private void validateType(String input){
        for (char c: input.toCharArray()){
            if (!Character.isDigit(c)){
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateUnique(String input){
        List<Character> numbers = new ArrayList<>();
        for (char c: input.toCharArray()){
            if (numbers.contains(c)){
                throw new IllegalArgumentException();
            }
            numbers.add(c);
        }
    }
}
