package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
    private final String numbersString;
    private List<Integer> playerNumbers = new ArrayList<>(Collections.emptyList());

    public Player(String numbersString) {
        this.numbersString = numbersString;
        setPlayerNumber(numbersString);
    }

    /**
     * 플레이어의 숫자 목록을 가져온다.
     *
     * @return 플레이어의 숫자 목록
     */
    public List<Integer> getPlayerNumbers() {
        return this.playerNumbers;
    }

    private void setPlayerNumber(String numbersString) {
        this.playerNumbers = toList(numbersString);
    }

    private List<Integer> toList(String numbersString) {
        List<Integer> list = new ArrayList<>(Collections.emptyList());
        for (String number : numbersString.split("")) {
            list.add(Integer.parseInt(number));
        }
        return list;
    }
}
