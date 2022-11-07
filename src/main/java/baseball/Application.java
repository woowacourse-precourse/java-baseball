package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Integer> computer = getRandomNumberList();
    }

    private static List<Integer> getRandomNumberList() {
        List computer = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        return computer;
    }

}
