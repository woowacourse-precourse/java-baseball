package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
    private final String inputNumbers;
    private List<Integer> playerNumbers = new ArrayList<>(Collections.emptyList());

    public Player(String inputNumbers) {
        this.inputNumbers = inputNumbers;
        setPlayerNumber(inputNumbers);
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

    private void isException(List<Integer> playerNumbers) throws IllegalArgumentException {
        if (playerNumbers.size() != 3) {
            throw new IllegalArgumentException();
        }
    }
}
