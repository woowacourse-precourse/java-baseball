package baseball.domain;

import java.util.List;

public class Baseball {

    private List<Integer> numbers;

    public Baseball(List<Integer> numbers) {
        validate(numbers);
    }

    public boolean countSameNumber(Baseball baseball) {
        return true;
    }

    private void validate(List<Integer> numbers) {
        throw new IllegalArgumentException();
    }
}
