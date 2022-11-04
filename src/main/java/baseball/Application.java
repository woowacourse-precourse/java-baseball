package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    /**
     * 게임을 시작 할 때 생성하는 랜덤 넘버 3개 (이때 각 숫자는 중복이 없다)
     *
     * @return 랜덤으로 생성된 숫자를 가지는 List
     */
    public static List<Integer> generateRandomNumber() {
        List<Integer> randomNumbers = new ArrayList<>();
        while(randomNumbers.size() < 3) {
            int randomValue = Randoms.pickNumberInRange(1, 9);

            if(randomNumbers.contains(randomValue)) continue;

            randomNumbers.add(randomValue);
        }

        return randomNumbers;
    }

    public static void main(String[] args) {

    }
}
