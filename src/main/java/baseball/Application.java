package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final int NUMBER_SIZE = 3;

    private static List<Integer> generateRandomNumberBySize() {
        List<Integer> randomNumber = new ArrayList<>();
        while (randomNumber.size() < Application.NUMBER_SIZE) {
            int tempRandomNumber = generateRandomNumber();
            if (!randomNumber.contains(tempRandomNumber)) {
                randomNumber.add(tempRandomNumber);
            }
        }
        return randomNumber;
    }

    private static int generateRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> randomNumber = generateRandomNumberBySize();
        System.out.println(randomNumber);
    }
}
