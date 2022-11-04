package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(computersNumbers());
    }

    public static ArrayList<Integer> computersNumbers() {

        ArrayList<Integer> computerRandomNumbers = new ArrayList<Integer>();
        while (computerRandomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerRandomNumbers.contains(randomNumber)) {
                computerRandomNumbers.add(randomNumber);
            }
        }

        return computerRandomNumbers;
    }
}

