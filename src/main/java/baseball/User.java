package baseball;

import static baseball.ConstantAndMessage.*;

import java.util.List;

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
    private void checkingDuplication() {
        boolean duplication = false;
        for (int i = 0; i < inputNumber.size(); i++) {
            duplication |= i != inputNumber.lastIndexOf(inputNumber.get(i));
        }
        if (duplication) {
            makingError();
        }
    }
    public int strike(List<Integer> computer) {
        int strikeCount = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (inputNumber.get(i) == computer.get(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }
    public int ball(List<Integer> computer) {
        int ballCount = -strike(computer);
        for (int computerNumber : computer) {
            if (inputNumber.contains(computerNumber)) {
                ballCount++;
            }
        }
        return ballCount;
    }
}
