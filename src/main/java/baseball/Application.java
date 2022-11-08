package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class Application {

    static List<Integer> computer;

    public static void main(String[] args) {
        selectNumber();
    }

    private static void selectNumber() {
        computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
//        System.out.println(computer);
    }
}
