package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/** 게임 흐름을 제어하는 메서드를 제공합니다. */
public class GameContext {
    private final static int ANSWER_LENGTH = 3;
    private String answer;
    private GameState state;

    public String getAnswer() {
        return answer;
    }

    public GameState getState() {
        return state;
    }

    public void initializeContext() {
        answer = getRandomNumber();
        state = GameState.RUNNING;
    }

    public String getRandomNumber() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < ANSWER_LENGTH)
            addDistinctRandomNumber(numbers);

        return numbers.stream().map(Object::toString)
                .collect(Collectors.joining());
    }

    public void addDistinctRandomNumber(List<Integer> numbers) {
        int randomNumber = Randoms.pickNumberInRange(1, 9);

        if (!numbers.contains(randomNumber))
            numbers.add(randomNumber);
    }
}
