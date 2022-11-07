package baseball;

import java.util.ArrayList;
import java.util.List;

public class User {

    List<Integer> userInputList = new ArrayList<>();
    public User() {
    }

    public List<Integer> getUserInputList() {
        return userInputList;
    }

    public void convertGuessInputToList (String userInput){
        userInputList.clear();
        for(int i = 0 ; i < userInput.length(); i++){
            char eachCharInput = userInput.charAt(i);
            int eachIntInput = Character.getNumericValue(eachCharInput);
            userInputList.add(eachIntInput);
        }
    }

    public void getUserGuessInput() {
        String userInput = camp.nextstep.edu.missionutils.Console.readLine();
        if (validateUserGuessInput(userInput)) {
            convertGuessInputToList(userInput);
        }
    }

    public boolean validateUserGuessInput(String userInput) {
        try {
            int userInt = Integer.parseInt(userInput);
            if (userInt < 0 || userInt > 999) {
                throw new NumberFormatException();
            }
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
