package baseball;

import java.util.List;
import camp.nextstep.edu.missionutils.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static void getComputersRandomNumber(List<Integer> computersNumber) {
        while (computersNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computersNumber.contains(randomNumber)) {
                computersNumber.add(randomNumber);
            }
        }
    }
}
