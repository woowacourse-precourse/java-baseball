package baseball;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {


    private static int GenerateNonDuplicateRandomNumber(List<Integer> randNum) {
        int k;
        do {
            k = Randoms.pickNumberInRange(1, 9);
        }
        while (randNum.contains(k));
        return k;
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
