package baseball.domain.number;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class BaseBallGameNumbers {

    private static final int SIZE = 3;

    private final Set<BaseBallGameNumber> numbers = new LinkedHashSet<>();

    public BaseBallGameNumbers(String input) {
        // 입력의 길이가 너무 길어졌을 때 하나하나 변환하는 것을 막기 위해 최초 검사한다.
        validateInputSize(input);

        for (String number : input.split("")) {
            numbers.add(new BaseBallGameNumber(number));
        }

        // 중복된 입력이 있을 수 있으므로 변환 후 한번 더 검사한다.
        validateNumberSize();
    }

    public BaseBallGameNumbers(List<Integer> integers) {
        for (Integer number : integers) {
            numbers.add(new BaseBallGameNumber(number));
        }

        validateNumberSize();
    }

    private void validateInputSize(String input) {
        if (SIZE != input.length()) {
            throw new IllegalArgumentException("입력의 길이는 3이어야 합니다.");
        }
    }

    private void validateNumberSize() {
        if (SIZE != numbers.size()) {
            throw new IllegalArgumentException("입력의 길이는 3이어야 합니다.");
        }
    }

    public List<BaseBallGameNumber> numbers() {
        // Set은 1개씩 접근이 안되므로 1개씩 비교하기 위해 List로 변환하여 반환
        return new ArrayList<>(numbers);
    }
}
