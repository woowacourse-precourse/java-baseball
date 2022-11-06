package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static List<Integer> createComputerNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static boolean hasZero(List<Integer> list) {
        int sum = 1;
        for (int elem : list) sum *= elem;
        return sum == 0;
    }

    public static boolean hasDuplicates(List<Integer> list) {
        Set<Integer> set = new HashSet<>();
        for (int elem : list) {
            if (!set.add(elem)) return false;
        }
        return true;
    }

    public static boolean isNumberInRange(int number){
        return ((number / 100 >= 1) && (number / 100 < 10));
    }
}
