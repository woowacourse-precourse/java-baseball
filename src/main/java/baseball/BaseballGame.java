package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    public final static String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    public final static int NUMBER_COUNT_TO_CREATED = 3;

    private List<Integer> computerNumbers = new ArrayList<>();

    public void start() {
        System.out.println(GAME_START_MESSAGE);
        createComputerNumbers();
        String input = Console.readLine();

        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }

        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }
    }

    private void createComputerNumbers() {
        computerNumbers = Randoms
                .pickUniqueNumbersInRange(1, 9, NUMBER_COUNT_TO_CREATED);
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }
}
