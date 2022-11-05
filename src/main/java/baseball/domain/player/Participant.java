package baseball.domain.player;

import baseball.domain.number.BaseballNumber;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Participant implements Player {
    public static final String ERROR_SIZE = "[ERROR] 길이는 오직 3자리입니다.";
    public static final String ERROR_FORMAT = "[ERROR] 문자열의 구성요소는 숫자로만 이루어져야 합니다.";

    private static final Integer FIX_SIZE = 3;
    private final List<BaseballNumber> numbers;

    public Participant(String input) {
        if (input.equals("")) {
            throw new IllegalArgumentException(ERROR_SIZE);
        }
        validateInputSize(input);
        validateInputElementIsNumber(input);

        this.numbers = Arrays.stream(input.split(""))
                .map(BaseballNumber::new)
                .collect(Collectors.toList());

    }

    /**
     * 입력받은 문자열의 구성요소는 오직 숫자들로 이루어집니다.
     *
     * @param input
     */
    private void validateInputElementIsNumber(String input) {
        for (Character character : input.toCharArray()) {
            if (!Character.isDigit(character)) {
                throw new IllegalArgumentException(ERROR_FORMAT);
            }
        }
    }

    private void validateInputSize(String input) {
        if (input.length() != FIX_SIZE) {
            String sizeError = String.format(" [size =%d]", input.length());
            throw new IllegalArgumentException(ERROR_SIZE + sizeError);
        }
    }

    public List<BaseballNumber> numbers() {
        return this.numbers;
    }
}
