package baseball.domain;

import baseball.util.ErrorMessage;
import baseball.util.Number;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Player {
    List<Integer> numbers;

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
        if (!Objects.equals(input.length(), Number.PRESCRIBED_DIGITS)) {
            throw new IllegalArgumentException(ErrorMessage.PRESCRIBED_DIGITS);
        }

        List<Character> used = new ArrayList<>();
        for (char ch : input.toCharArray()) {
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException(ErrorMessage.DIGIT);
            }
            if (Objects.equals(Number.ZERO, ch)) {
                throw new IllegalArgumentException(ErrorMessage.NOT_ZERO);
            }
            if (used.contains(ch)) {
                throw new IllegalArgumentException(ErrorMessage.NOT_DUPLICATION);
            }
            used.add(ch);
        }
    }

    List<Integer> convertInput(String input) {
        return input.chars()
                .mapToObj(ch -> (char)ch)
                .map(Character::getNumericValue)
                .collect(Collectors.toList());
    }
}
