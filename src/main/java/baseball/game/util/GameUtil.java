package baseball.game;

import baseball.validator.Validator;
import baseball.condition.Condition;
import baseball.condition.gameinput.AllDigitsUniqueCond;
import baseball.condition.gameinput.AllDigitsNumberCond;
import baseball.condition.gameinput.SmallerThanMaxSizeCond;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameUtil {

    private final static Integer RANDOM_RANGE_MIN = 1;
    private final static Integer RANDOM_RANGE_MAX = 9;
    public static final Integer NUMBER_SIZE = 3;
    public static final Integer STRIKE_OUT_COUNT = 3;

    private final static Validator validator = new Validator();

    public Integer getRandomNumber() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(RANDOM_RANGE_MIN, RANDOM_RANGE_MAX);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }

        return Integer.parseInt(numbers.stream().map((Integer number) -> Integer.toString(number)).collect(Collectors.joining("")));
    }

    public Integer getUserInput() {
        Integer guess = Integer.parseInt(Console.readLine());

        List<Condition> conditions = List.of(new AllDigitsUniqueCond(), new AllDigitsNumberCond(), new SmallerThanMaxSizeCond());

        if (validator.isSomeConditionsFalse(guess, conditions)) {
            throw new IllegalArgumentException();
        }

        return guess;
    }
}
