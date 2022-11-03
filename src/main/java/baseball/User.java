package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class User {

    public List<Integer> pickNumbers(){
        System.out.print("숫자를 입력해주세요 : ");
        String numbers = Console.readLine();
        validateInput(numbers);

        return StringToList(numbers);
    }

    private List<Integer> StringToList(String input){
        List<Integer> result = new ArrayList<>();

        for (char c: input.toCharArray()){
            result.add(Character.getNumericValue(c));
        }
        return result;
    }

    public void validateInput(String input){
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
