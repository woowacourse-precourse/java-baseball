package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        List<String> computerNumber = getComputerNumber();
    }

    private static ArrayList<String> getComputerNumber() {
        ArrayList<String> computerNumber = new ArrayList<>();

        while (computerNumber.size() < 3) {
            String number = Integer.toString(Randoms.pickNumberInRange(1, 9));

            if (!computerNumber.contains(number)) {
                computerNumber.add(number);
            }
        }

        return computerNumber;
    }
}
