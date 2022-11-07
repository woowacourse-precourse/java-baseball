package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static final int NEW_GAME_NUMBER = 1;
    static final int END_GAME_NUMBER = 2;

    static final int MIN_RANGE_NUM = 1;
    static final int MAX_RANGE_NUM = 9;
    static final int MAX_ARRAY_SIZE = 3;
    static final int ZERO_VALUE = 0;

    public boolean threeStrike = false;

    public static void main(String[] args) {
        Application app = new Application();
    }

    // TODO : 컴퓨터가 1에서 9까지의 서로다른 임의의 수 3개를 선택한다.
    public List<Integer> SelectRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < MAX_ARRAY_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANGE_NUM, MAX_RANGE_NUM);
            if (!numbers.contains(randomNumber)){
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    // TODO : 사용자가 숫자를 선택한 숫자를 리턴
    public List<Integer> selectNumbers(){
        String inputNumber = Console.readLine();

        // TODO : 사용자가 잘못된 값을 입력할 시 IllegalArgumentException 발생
        isInputMatch(inputNumber);

        // TODO : 사용자가 선택한 숫자를 List에 담아 리턴
        List<Integer> numbers = new ArrayList<>();
        for (char number : inputNumber.toCharArray())
            numbers.add(Character.getNumericValue(number));

        return numbers;
    }

    // TODO : 사용자가 잘못된 값을 입력할 시 IllegalArgumentException 발생하는 함수
    public void isInputMatch(String inputNumber){
        // 입력 값의 길이가 3이 아닐 시, 0이 포함되어 있을 시, 숫자 이외의 값이 포함되어 있을 시 예외처리
        if (inputNumber.length() != 3
                || inputNumber.contains("0")
                || !inputNumber.replaceAll("[1-9]", "").isEmpty())
            throw new IllegalArgumentException();
    }
}
