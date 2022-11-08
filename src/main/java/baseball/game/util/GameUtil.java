package baseball.game.util;

import baseball.console.Interactive;
import baseball.validation.Validator;
import baseball.validation.Condition;
import baseball.game.condition.AllDigitsUniqueCond;
import baseball.game.condition.AllDigitsNumberCond;
import baseball.game.condition.LengthMatchCond;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameUtil implements Interactive {

    private static final GameUtil instance = new GameUtil();
    private final static Validator validator = Validator.getInstance();
    private static final Integer RANDOM_RANGE_MIN = 1;
    private static final Integer RANDOM_RANGE_MAX = 9;
    public static final Integer STRIKE_OUT_COUNT = 3;
    public static final Integer NUMBER_SIZE = 3;

    private GameUtil() {
    }

    public static GameUtil getInstance() {
        return instance;
    }


    public String getRandomNumber() {
        List<String> numbers = new ArrayList<>();

        while (numbers.size() < NUMBER_SIZE) {
            String randomNumber = Integer.toString(Randoms.pickNumberInRange(RANDOM_RANGE_MIN, RANDOM_RANGE_MAX));

            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }

        return String.join("", numbers);
    }

    @Override
    public String getUserInput() {
        String guess = Console.readLine();

        List<Condition> conditions = List.of(
                LengthMatchCond.getInstance(),
                AllDigitsUniqueCond.getInstance(),
                AllDigitsNumberCond.getInstance()
        );

        if (validator.isAnyConditionsFalse(guess, conditions)) {
            throw new IllegalArgumentException();
        }

        return guess;
    }
}
