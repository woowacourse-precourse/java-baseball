package baseball;

import java.util.ArrayList;
import java.util.List;

public class Player {
    /**
     * 플레이어에게 입력 받은 값을 리스트에 한글자씩 담아 반환합니다.
     */
    public List<Integer> createPlayerNumbers(String input) {
        List<Integer> playerNumbers = new ArrayList<>();

        for (String splitValue : input.split("")) {
            playerNumbers.add(Integer.valueOf(splitValue));
        }

        return playerNumbers;
    }
}
