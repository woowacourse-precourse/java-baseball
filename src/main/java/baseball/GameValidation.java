package baseball;

import baseball.resource.GameValue;

import java.util.ArrayList;
import java.util.List;

public final class GameValidation {
    private String userInput;
    private List<Character> userInputList;

    public void setUserInput(String userInput) {
        this.userInput = userInput;
        ConvertUserInputToList();
    }

    public void ConvertUserInputToList() {
        userInputList = new ArrayList<>();

        for(int i = 0; i < userInput.length(); i++) {
            userInputList.add(userInput.charAt(i));
        }
    }

    public boolean isCheckLength() {
        if (userInput.length() == 3) {
            return true;
        }

        throw new IllegalArgumentException();
    }

    public boolean isAllCorrectNumber() {
        userInputList.forEach(str -> {
            if (!(GameValue.START_NUMBER <= str  && str <= GameValue.END_NUMBER)) {
                throw new IllegalArgumentException();
            }
        });

        return true;
    }
}
