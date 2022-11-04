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
        this.playerNumbers = toList(inputNumbers);
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
            inputNumberByList(list, number);
        }
        return list;
    }

    /**
     * 문자를 리스트에 넣는다.<br>
     * 만약 리스트에 넣지 못한다면 IllegalArgumentException를 던진다.
     * @param list 리스트
     * @param number    문자로 되어있는 숫자
     */
    private void inputNumberByList(List<Integer> list, String number) {
        try {
            list.add(Integer.parseInt(number));
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }
    }
}
