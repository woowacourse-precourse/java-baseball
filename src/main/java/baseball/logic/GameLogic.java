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
        Result.initialize();

        for (int i = 0; i < 3; i++) {
            computerNumbersTable.set(computerNumbers.charAt(i) - '0', i);
        }
    }

    public void process(String userNumbers) {
        Result.initialize();

        compareIndices(userNumbers);
    }

    private void compareIndices(String userNumbers) {
        for (Integer index = 0; index < 3; index++) {
            Integer computerIndex = computerNumbersTable.get(userNumbers.charAt(index) - '0');
            updateResult( index, computerIndex);
        }
    }

    private void updateResult( Integer userIndex, Integer computerIndex) {
        Result result = compareIndex(userIndex, computerIndex);

        Result.update(result);
    }

    private Result compareIndex(Integer userIndex, Integer computerIndex) {
        return Result.judge(userIndex, computerIndex);
    }
}
