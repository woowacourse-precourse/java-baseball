package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Application application = new Application();
        List<Integer> computer = new ArrayList<>();

        System.out.println("숫자 야구 게임을 시작합니다.");
        computer = application.createRandomNumbersInList();
    }

    public List<Integer> createRandomNumbersInList() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }
}
