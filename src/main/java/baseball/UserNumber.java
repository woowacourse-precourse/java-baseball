package baseball;

import java.util.ArrayList;
import java.util.List;

public class UserNumber {

    private static final int GAME_NUMBERS_SIZE = 3;

    private final List<Integer> userNumbers;

    public UserNumber() {
        String input = Input.getThreeNumbers();
        this.userNumbers = createUserNumbers(input);
    }

    public List<Integer> getList() {
        return userNumbers;
    }

    private List<Integer> createUserNumbers(String input) {
        validate(input);
        List<Integer> threeNumbers = makeList(input);
        return threeNumbers;
    }

    private void validate(String input) {
        Validator validator = new Validator(input);
        try {
            validator.isLengthThree();
            validator.isAllNumber();
            validator.notContainsZero();
            validator.isAllDifferent();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private List<Integer> makeList(String input) {
        List<Integer> threeNumbers = new ArrayList<>();
        for (int i = 0; i < GAME_NUMBERS_SIZE; i++) {
            threeNumbers.add(input.charAt(i) - '0');
        }
        return threeNumbers;
    }
}
