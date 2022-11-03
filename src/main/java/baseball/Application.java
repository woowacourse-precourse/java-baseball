package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Application {
    public static void main(String[] args) {
        System.out.print("숫자 야구 게임을 시작합니다.\n");
    }
    private static int generateRandomValue() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return ((computer.get(0) * 100) + (computer.get(1) * 10) + computer.get(2));
    }
}
