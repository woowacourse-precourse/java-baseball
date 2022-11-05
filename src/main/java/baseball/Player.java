package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
    private static final int INPUT_NUMBER_SIZE = 3;
    private List<Integer> playerNumbers = new ArrayList<>(Collections.emptyList());

    public Player(String inputNumbers) {
        setPlayerNumber(inputNumbers);
    }

    /**
     * 플레이어가 입력한 숫자의 개수가 INPUT_NUMBER_SIZE 와 다르면 예외를 던진다.
     *
     * @param playerNumbers 플레어어가 입력한 숫자들
     * @throws IllegalArgumentException 플레이어의 입력 숫자 갯수가 INPUT_NUMBER_SIZE 와 다르면 던진다.
     */
    private static void isNumberCountException(List<Integer> playerNumbers) throws IllegalArgumentException {
        if (playerNumbers.size() != INPUT_NUMBER_SIZE) {
            throw new IllegalArgumentException("입력한 숫자의 개수가 " + INPUT_NUMBER_SIZE + "개가 아닙니다.");
        }
    }

    /**
     * 중복 숫자가 있으면 예외를 던진다.
     *
     * @param playerNumbers 플레이어가 입력한 숫자들
     * @throws IllegalArgumentException 플레이어의 입력 숫자중 증복 숫자가 있으면 던진다.
     */
    private static void isDuplicateNumberException(List<Integer> playerNumbers) throws IllegalArgumentException {
        boolean[] checkNumbers = new boolean[10];
        for (Integer playerNumber : playerNumbers) {
            if (checkNumbers[playerNumber]) {
                throw new IllegalArgumentException("입력한 숫자 중에 중복된 숫자가 있습니다.");
            }
            checkNumbers[playerNumber] = true;
        }
    }

    /**
     * 플레이어의 숫자 목록을 가져온다.
     *
     * @return 플레이어의 숫자 목록
     */
    public List<Integer> getPlayerNumbers() {
        return this.playerNumbers;
    }

    /**
     * 플레이어의 입력받은 수 저장
     *
     * @param inputNumbers 플레이어의 입력한 숫자들
     */
    private void setPlayerNumber(String inputNumbers) {
        List<Integer> list = toList(inputNumbers);
        isException(list);
        this.playerNumbers = list;
    }

    /**
     * 문자열을 리스트로 변환한다.
     *
     * @param inputNumbers 플레이어의 입력한 숫자들
     * @return 플레이어의 입력한 숫자들 리스트로 변환한 것을 반환
     */
    private List<Integer> toList(String inputNumbers) {
        List<Integer> list = new ArrayList<>(Collections.emptyList());
        for (String number : inputNumbers.split("")) {
            list.add(Integer.parseInt(number));
        }
        return list;
    }

    /**
     * 플레이어가 입력한 숫자의 예외 사항을 체크한다.
     *
     * @param playerNumbers 플레이어가 입력한 숫자들
     * @throws IllegalArgumentException 예외 사항이 발생하면 던진다.
     */
    private void isException(List<Integer> playerNumbers) throws IllegalArgumentException {
        isNumberCountException(playerNumbers);
        isDuplicateNumberException(playerNumbers);
    }
}
