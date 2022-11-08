package baseball;

import camp.nextstep.edu.missionutils.Console;
import util.Constants;
import util.UserInput;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<Integer> numbers;

    private void setNumbers() {

        System.out.print(Constants.USER_INPUT);

        numbers = new ArrayList<>();
        String userInput = Console.readLine();
        if (UserInput.isValidUserInput(userInput)){

            for (int i=0; i<userInput.length(); i++){
                Character c = userInput.charAt(i);
                numbers.add(Character.getNumericValue(c));
            }
        }else{
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        setNumbers();
        return numbers;
    }
}
