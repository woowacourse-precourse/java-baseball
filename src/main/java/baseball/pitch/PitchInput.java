package baseball.pitch;

import java.util.ArrayList;
import java.util.List;

public class PitchInput {

    private List<Integer> number = new ArrayList<>();

    public PitchInput(String input) {

        for (int index = 0; index < 3; index++) {
            int each = input.charAt(index) - '0';

            validateValueRange(each);
            validateDuplication(each);

            number.add(each);
        }
    }

    public List<Integer> getNumber() {
        return number;
    }

    private void validateValueRange(int value) {
        if (value < 1 || value > 9) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    private void validateDuplication(int value) {
        if (number.contains(value)) {
            throw new IllegalArgumentException("서로 다른 숫자를 입력해주세요.");
        }
    }
}
