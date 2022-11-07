package baseball.service;

import baseball.domain.Player;
import baseball.exception.InputException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerService {
    private static final int LIST_SIZE = 3;
    InputException inputException = new InputException();
    Player player = new Player();

    /**
     * 입력받은 문자가 숫자가 아니면 예외를 던진다.
     *
     * @param inputString 입력받은 문자
     * @return 숫자인 입력받은 문자
     */
    private String checkDigit(String inputString) {
        inputException.isDigitException(inputString);
        return inputString;
    }

    /**
     * 입력받은 문자가 리스트에 중복이 있으면 예외를 던지고 없으면 <br>
     * 문자를 숫자로 변환하여 반환한다.
     *
     * @param numbers     플레이어가 입력한 숫자들
     * @param inputNumber 입력받은 숫자
     * @return 중복이 아닌 int 로 변환된 숫자
     */
    private int numberToInt(List<Integer> numbers, String inputNumber) {
        int addNumber = Integer.parseInt(inputNumber);
        inputException.isDuplicationNumberException(addNumber, numbers);
        return addNumber;
    }

    /**
     * 플레이어가 입력한 숫자의 개수를 확인한후 예외가 있으면 던진다. <br>
     * 정상이라면 String 배열로 변환시킨뒤 변환된 numbers 리스트를 player 저장한다.
     *
     * @param inputNumbers 입력한 숫자들
     * @return 플레이어
     */
    public void inputNumbersToPlayer(String inputNumbers) {
        inputException.isInvalidNumbersSize(inputNumbers);
        player.setNumbers(getNumbersToList(inputNumbers.split("")));
    }

    /**
     * 플레이어를 가져온다.
     * @return 플레이어
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * inputNumbers 배열을 리스트로 변환하여 반환
     *
     * @param inputNumbers 입력한 숫자들의 배열
     * @return 변환한 numbers 리스트
     */
    private List<Integer> getNumbersToList(String[] inputNumbers) {
        List<Integer> numbers = new ArrayList<>(Collections.emptyList());
        for (int i = 0; i < LIST_SIZE; i++) {
            String inputNumber = checkDigit(inputNumbers[i]);
            int addNumber = numberToInt(numbers, inputNumber);
            numbers.add(addNumber);
        }
        return numbers;
    }
}
