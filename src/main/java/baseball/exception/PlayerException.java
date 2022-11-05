package baseball.exception;

import java.util.List;

public class PlayerException {
    private static final int INPUT_NUMBER_SIZE = 3;

    /**
     * 플레이어의 입력받은 숫자들이 정상인지 확인하고 아니면 예외 처리로 던진다.
     * @param playerNumbers 플레이어의 숫자들
     */
    public void inputExceptionCheck(List<Integer> playerNumbers) {
        duplicateNumberException(playerNumbers);
        numberSizeException(playerNumbers);
    }

    /**
     * 중복 숫자가 있으면 예외를 던진다.
     *
     * @param playerNumbers 플레이어가 입력한 숫자들
     * @throws IllegalArgumentException 플레이어의 입력 숫자중 증복 숫자가 있으면 던진다.
     */
    private void duplicateNumberException(List<Integer> playerNumbers) throws IllegalArgumentException {
        boolean[] checkNumbers = new boolean[10];
        for (Integer playerNumber : playerNumbers) {
            if (checkNumbers[playerNumber]) {
                throw new IllegalArgumentException("입력한 숫자 중에 중복된 숫자가 있습니다.");
            }
            checkNumbers[playerNumber] = true;
        }
    }

    /**
     * 플레이어가 입력한 숫자의 개수가 INPUT_NUMBER_SIZE 와 다르면 예외를 던진다.
     *
     * @param playerNumbers 플레어어가 입력한 숫자들
     * @throws IllegalArgumentException 플레이어의 입력 숫자 갯수가 INPUT_NUMBER_SIZE 와 다르면 던진다.
     */
    private void numberSizeException(List<Integer> playerNumbers) throws IllegalArgumentException {
        if (playerNumbers.size() != INPUT_NUMBER_SIZE) {
            throw new IllegalArgumentException("입력한 숫자의 개수가 " + INPUT_NUMBER_SIZE + "개가 아닙니다.");
        }
    }
}
