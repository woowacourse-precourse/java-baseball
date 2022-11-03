package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static List<String> computer;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public void initComputer() {
        computer = new ArrayList<>();
        while (computer.size() < 3) {
            String randomNumber = String.valueOf(Randoms.pickNumberInRange(1, 9));

            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }
}
