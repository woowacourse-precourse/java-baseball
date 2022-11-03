package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ArrayList<Integer> computerNumbers = getRandomNumbers();

    }

    public static ArrayList<Integer> getRandomNumbers() {
        ArrayList<Integer> threeRandomNumbers = new ArrayList<>(3);
        while (threeRandomNumbers.size() < 3) {
            int num = Randoms.pickNumberInRange(1, 9);
            if (!threeRandomNumbers.contains(num))
                threeRandomNumbers.add(num);
        }
        return threeRandomNumbers;
    }
}
