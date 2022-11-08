package baseball.validation;

import baseball.resource.GameValue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class GameValidation {
    private String userInput;
    private List<Character> userInputList;

    public void setUserInput(String userInput) {
        this.userInput = userInput;
        ConvertUserInputToList();
    }

    private void ConvertUserInputToList() {
        this.userInputList = new ArrayList<>();

        for (int i = 0; i < this.userInput.length(); i++) {
            this.userInputList.add(this.userInput.charAt(i));
        }
    }

    public void isAllCheck() {
        if (isCheckLength() && isAllCorrectNumber() && isNotDuplicateNumber()) {
            return;
        }

        throw new IllegalArgumentException();
    }

    private boolean isCheckLength() {
        if (userInput.length() == GameValue.CORRECT_LENGTH) {
            return true;
        }

        throw new IllegalArgumentException();
    }

    private boolean isAllCorrectNumber() {
        userInputList.forEach(str -> {
            if (!(GameValue.START_NUMBER <= str && str <= GameValue.END_NUMBER)) {
                throw new IllegalArgumentException();
            }
        });

        return true;
    }

    private boolean isNotDuplicateNumber() {
        Set<Character> userInputSet = new HashSet<>(userInputList);

        if (userInputSet.size() == GameValue.CORRECT_LENGTH) {
            return true;
        }

        throw new IllegalArgumentException();
    }
}
