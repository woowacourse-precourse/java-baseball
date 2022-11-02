package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {

    public void pickNumbers(){
        String numbers = Console.readLine();

        validateInput(numbers);
    }

    private void validateInput(String input){
        validateLength(input);
        validateType(input);
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
}
