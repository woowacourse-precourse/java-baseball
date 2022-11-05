package baseball.domain;

import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Player {
    List<Integer> numbers = new ArrayList<>();

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void redefineNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void guessNumbers() {
        OutputView.printInputRequest();
        String input = InputView.inputString();
        checkInput(input);
        redefineNumbers(convertInput(input));
    }

    void checkInput(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
        boolean[] used = new boolean[10];
        used[0] = true;
        for (char ch : input.toCharArray()) {
            if (!Character.isDigit(ch) || used[ch - '0']) {
                throw new IllegalArgumentException();
            }
            used[ch - '0'] = true;
        }
    }

    List<Integer> convertInput(String input) {
        List<Integer> convertedIntegers = new ArrayList<>();
        for (char ch: input.toCharArray()) {
            convertedIntegers.add(Character.getNumericValue(ch));
        }
        return convertedIntegers;
    }
}
