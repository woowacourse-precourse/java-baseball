package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    public static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    public static final String INPUT_GUIDE = "숫자를 입력해주세요 : ";

    public List<Integer> generateRandomNumber() {
        List<Integer> numbers = new ArrayList<>();
        do {
            int number = Randoms.pickNumberInRange(1, 9);
            addUniqueNumber(numbers, number);
        } while (numbers.size() < 3);
        return numbers;
    }

    public void addUniqueNumber(List<Integer> numbers, int number) {
        if (!numbers.contains(number)) {
            numbers.add(number);
        }
    }
}
