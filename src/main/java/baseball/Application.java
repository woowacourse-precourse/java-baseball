package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    public static int distinguishOut (List<Integer> inputNumberList, List<Integer> computerNumberList) {
        int outCounting = 0;

        for (int i = 0; i <3; i++) {
            if (inputNumberList.get(i) == computerNumberList.get(i)) {
                outCounting += 1;
            }
        }

        return outCounting;
    }

    public static int distinguishStrike (List<Integer> inputNumberList, List<Integer> computerNumberList, int outCounting) {
        int strikeCounting = 0;

        for (int i = 0; i < 3; i++) {
            if (computerNumberList.contains(inputNumberList.get(i))) {
                strikeCounting += 1;
            }
        }

        return strikeCounting - outCounting;
    }

    public List<Integer> makeComputerNumber () {
        List<Integer> computerNumberList = new ArrayList<>();
        for (int j = 0; j < 3; j++) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumberList.contains(randomNumber)) {
                computerNumberList.add(randomNumber);
            }
        }
        return computerNumberList;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
