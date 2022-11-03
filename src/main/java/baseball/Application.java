package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

    }

    public static List<Integer> computerNumberList() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNum)) {
                computer.add(randomNum);
            }
        }
        return computer;
    }

    public static List<Integer> createUserNumberList(String number) {
        List<Integer> user = new ArrayList<>();

        for (int i = 0; i < number.length(); i++) {
            int numberToInt = Integer.parseInt(String.valueOf(number.charAt(i)));
            user.add(numberToInt);
        }
        return user;
    }
}
