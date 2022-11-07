package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        while (true) {
            int inputNumber = Integer.parseInt(Console.readLine());

            int exitCode = Integer.parseInt(Console.readLine());
            if (exitCode == 2) {
                break;
            }
        }
    }

    private static List<Integer> createRandomNumber() {
        List<Integer> createdNumber = new ArrayList<>();
        while (createdNumber.size() != 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!createdNumber.contains(randomNumber)) {
                createdNumber.add(randomNumber);
            }
        }

        return createdNumber;
    }
}
