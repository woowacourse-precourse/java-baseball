package baseball.logic;

import baseball.domain.Result;
import java.util.ArrayList;
import java.util.List;

public class GameLogic {
    /*
    0 번 엔트리는 사용하지 않는다.
    계산 편의를 위해 사이즈를 10으로 잡음.
     */
    private final int ENTRY_SIZE = 10;
    private final int NUMBER_NOT_APPEARED = -1;
    private List<Integer> computerNumbersTable = new ArrayList<>(ENTRY_SIZE);

    /**
     * 1 ~ 9 의 숫자가 등장한 인덱스를 모두 -1로 초기화
     */
    {
        while (computerNumbersTable.size() < ENTRY_SIZE) {
            computerNumbersTable.add(NUMBER_NOT_APPEARED);
        }
    }

    public void setUp(String computerNumbers) {
        for (int i = 0; i < 3; i++) {
            computerNumbersTable.set(computerNumbers.charAt(i) - '0', i);
        }
    }

    public void process(String userNumbers, Result result) {
        result.setBall(0);
        result.setStrike(0);
        for (Integer i = 0; i < 3; i++) {
            Integer computerIndex = computerNumbersTable.get(userNumbers.charAt(i) - '0');
            compare(result, i, computerIndex);
        }
    }

    private void compare(Result result, Integer userIndex, Integer computerIndex) {
        if (computerIndex == userIndex) {
            result.addStrike();
        } else if (computerIndex != -1 && computerIndex != userIndex) {
            result.addBall();
        }
    }

}
