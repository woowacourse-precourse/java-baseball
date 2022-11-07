package baseball.domain;

import baseball.exception.PlayerException;
import baseball.exception.TypeException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
    private final PlayerException playerException = new PlayerException();
    private final TypeException typeException = new TypeException();
    private List<Integer> playerNumbers = new ArrayList<>(Collections.emptyList());

    public Player(String inputNumbers) {
        initPlayer(inputNumbers);
        numbersExceptionCheck(playerNumbers);
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
     * 플레이어의 입력받은 문자열을 리스트로 저장하여 초기화한다.
     *
     * @param inputNumbersString 플레이어의 입력한 숫자들
     */
    private void initPlayer(String inputNumbersString) {
        this.playerNumbers = toList(inputNumbersString);
    }

    /**
     * 문자열을 리스트로 변환하며 예외가 있으면 던진다.
     *
     * @param inputNumbersString 플레이어의 입력한 숫자들
     * @return 플레이어의 입력한 숫자들 리스트로 변환한 것을 반환
     */
    private List<Integer> toList(String inputNumbersString) {
        typeException.typeException(inputNumbersString);
        List<Integer> list = new ArrayList<>(Collections.emptyList());
        for (String number : inputNumbersString.split("")) {
            addNumberByList(list, number);
        }
        return list;
    }

    private void addNumberByList(List<Integer> list, String number) {
        list.add(Integer.parseInt(number));
    }

    /**
     * 플레이어의 숫자 목록중 예외가 있는지 확인하고 있으면 던진다.
     * @param playerNumbers 플레이어의 숫자 목록
     */
    private void numbersExceptionCheck(List<Integer> playerNumbers) {
        playerException.inputExceptionCheck(playerNumbers);
    }
}
