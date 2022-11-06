package baseball;

import static baseball.ConstantAndMessage.*;

public class User extends NumberInput {

    public User(String input) {
        super(input);
        inputLength = NUMBER_LENGTH;
        allowedNumbers = ALLOWED_INPUT_NUMBERS;
    }
    @Override
    public void errorChecking() {
        checkingLength();
        checkingNumbers();
        checkingDuplication();
    }
    private void checkingDuplication(){
        boolean duplication = false;
        for (int i = 0; i < inputNumber.size(); i++) {
            duplication |= i != inputNumber.lastIndexOf(inputNumber.get(i));
        }
        if(duplication){
            makingError();
        }
    }
}
