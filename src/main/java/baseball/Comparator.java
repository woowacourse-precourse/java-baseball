package baseball;

import java.util.List;

public class Comparator {
    private final List<Integer> computerNumbers;
    private final List<Integer> playerNumbers;
    private final int[] result = {0, 0};

    public Comparator(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        this.computerNumbers = computerNumbers;
        this.playerNumbers = playerNumbers;
    }

    /**
     * 숫자 야구의 결과를 가져온다.
     *
     * @return 숫자 야구의 결과를 반환
     */
    public int[] getResult() {
        for (int i = 0; i < 3; i++) {
            int computerNumber = computerNumbers.get(i);
            int playerNumber = playerNumbers.get(i);
            inputResult(computerNumber, playerNumber);
        }
        return result;
    }

    /**
     * 컴퓨터와 플레이어의 숫자를 비교하여 결과를 넣는다.
     *
     * @param computerNumber 컴퓨터의 숫자
     * @param playerNumber   플레이어의 숫자
     */
    private void inputResult(int computerNumber, int playerNumber) {
        if (computerNumber == playerNumber) {
            result[0] += 1;
        } else {
            result[1] += 1;
        }
    }
}
