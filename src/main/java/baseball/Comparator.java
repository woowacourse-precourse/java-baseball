package baseball;

import java.util.List;

public class Comparator {
    private int[] result = {0, 0};

    public Comparator(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        this.result = inputResult(computerNumbers, playerNumbers);
    }

    /**
     * 숫자 야구의 결과를 가져온다.
     *
     * @return 숫자 야구의 결과를 반환
     */
    public int[] getResult() {
        return result;
    }

    /**
     * 컴퓨터의 숫자들에 플레이어의 숫자가 있는가를 확인
     *
     * @param playerNumber 플레이어의 숫자
     * @return 플레이어의 숫자가 컴퓨터의 숫자들에 있으면 true
     */
    private boolean hasPlayerNumberByComputerNumbers(List<Integer> computerNumbers, int playerNumber) {
        return computerNumbers.contains(playerNumber);
    }

    /**
     * 숫자 야구의 결과를 입력한다.
     */
    public int[] inputResult(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        for (int i = 0; i < 3; i++) {
            int computerNumber = computerNumbers.get(i);
            int playerNumber = playerNumbers.get(i);
            if (hasPlayerNumberByComputerNumbers(computerNumbers, playerNumber)) {
                isStrike(computerNumber, playerNumber);
                isBall(computerNumber, playerNumber);
            }
        }
        return result;
    }

    /**
     * 컴퓨터와 플레이어의 숫자를 비교하여 볼인지 확인하고
     * 볼이면 1점을 더한다.
     *
     * @param computerNumber 컴퓨터의 숫자
     * @param playerNumber   플레이어의 숫자
     */
    private void isBall(int computerNumber, int playerNumber) {
        if (computerNumber != playerNumber) {
            result[0] += 1;
        }
    }

    /**
     * 컴퓨터와 플레이어의 숫자를 비교하여 스트라이크인지 확인하고
     * 스트라이크면 1점을 더한다.
     *
     * @param computerNumber 컴퓨터의 숫자
     * @param playerNumber   플레이어의 숫자
     */
    private void isStrike(int computerNumber, int playerNumber) {
        if (computerNumber == playerNumber) {
            result[1] += 1;
        }
    }
}
