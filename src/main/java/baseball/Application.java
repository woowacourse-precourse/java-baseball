package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static String generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();

        // 중복되지 않는 3개의 숫자를 고른다
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }

        StringBuilder sb = new StringBuilder();
        numbers.forEach(sb::append);

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다");
    }
}
