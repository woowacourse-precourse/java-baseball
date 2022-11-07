package baseball.Players;

import baseball.Utils.Input;
import baseball.Utils.Validator;
import java.util.ArrayList;
import java.util.List;

public class UserNumber {

    private static final int GAME_NUMBERS_SIZE = 3;

    private final List<Integer> userNumbers;

    public UserNumber() {
        String input = Input.getThreeNumbers();
        this.userNumbers = createUserNumbers(input);
    }

    public List<Integer> getNumberList() {
        return userNumbers;
    }

    private List<Integer> createUserNumbers(String input) {
        validate(input);
        List<Integer> threeNumbers = makeList(input);
        return threeNumbers;
    }

    private void validate(String input) {
        Validator validator = new Validator(input);
        validator.isLengthThree();
        validator.isAllNumber();
        validator.notContainsZero();
        validator.isAllDifferent();
    }

    private List<Integer> makeList(String input) {
        List<Integer> threeNumbers = new ArrayList<>();
        for (int i = 0; i < GAME_NUMBERS_SIZE; i++) {
            threeNumbers.add(input.charAt(i) - '0');
        }
        return threeNumbers;
    }
}
