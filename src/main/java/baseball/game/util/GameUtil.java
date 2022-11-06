package baseball.game.util;

import baseball.console.Interactive;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameUtil implements Interactive {

    private static final GameUtil instance = new GameUtil();
    private static final Integer RANDOM_RANGE_MIN = 1;
    private static final Integer RANDOM_RANGE_MAX = 9;
    public static final Integer STRIKE_OUT_COUNT = 3;
    public static final Integer NUMBER_SIZE = 3;

    public static GameUtil getInstance() {
        return instance;
    }


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

    @Override
    public Integer getUserInput() {
        return 0;
    }
}
