package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        List<Integer> randomValues = makeRandomValues();
        System.out.println(randomValues);
    }

    private static List<Integer> makeRandomValues() {

        List<Integer> randomValues = new ArrayList<>();
        while (randomValues.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomValues.contains(randomNumber)) {
                randomValues.add(randomNumber);
            }
        }
        return randomValues;
    }


}
