package baseball.service;

import baseball.domain.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerService {
    private static final int LIST_SIZE = 3;
    Player player = new Player();

    /**
     * 플레이어가 입력한 inputNumbers 을 String 배열로 변환시킨뒤<br>
     * 변환된 numbers 리스트를 player 저장후 반환한다.
     *
     * @param inputNumbers 입력한 숫자들
     * @return 플레이어
     */
    public Player inputNumbersToPlayer(String inputNumbers) {
        player.setNumbers(getNumbers(inputNumbers.split("")));
        return player;
    }

    /**
     * inputNumbers 배열을 예외 처리를 거친뒤 예외가 있으면 예외를 던지고<br>
     * 아니면 리스트로 변환하여 반환
     *
     * @param inputNumbers 입력한 숫자들의 배열
     * @return 변환한 numbers 리스트
     */
    private List<Integer> getNumbers(String[] inputNumbers) {
        List<Integer> numbers = new ArrayList<>(Collections.emptyList());
        // TODO: 예외처리 ( 문자의 크기가 3이 아닐시 예외를 던짐 )
        // TODO: 예외처리 (입력한 문자에 숫자가 아닌 문자가 포함시 예외 처리 )
        for (int i = 0; i < LIST_SIZE; i++) {
            numbers.add(Integer.parseInt(inputNumbers[i]));
        }
        return numbers;
    }
}
