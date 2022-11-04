package baseball;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Application {


    public static List<Integer> GenerateRandomNumber(int digits) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < digits; i++) {
            list.add(GenerateNonDuplicateRandomNumber(list));
        }
        return list;
    }

    public static boolean isValidLength(int n) {
        return n == 3;
    }

    public static Set<Integer> isInputIsNonDuplicate(String s) {

        return null;


    }


    public static int GenerateNonDuplicateRandomNumber(List<Integer> randNum) {
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
