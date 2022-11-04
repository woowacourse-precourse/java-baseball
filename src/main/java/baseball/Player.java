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

    private void setPlayerNumber(String inputNumbers) {
        this.playerNumbers = toList(inputNumbers);
    }

    private List<Integer> toList(String inputNumbers) {
        List<Integer> list = new ArrayList<>(Collections.emptyList());
        for (String number : inputNumbers.split("")) {
            list.add(Integer.parseInt(number));
        }
        return list;
    }
}
