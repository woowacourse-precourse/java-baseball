package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static int distinguishStrike (List<Integer> inputNumberList, List<Integer> computerNumberList) {
        int strikeCounting = 0;

        for (int i = 0; i <3; i++) {
            if (inputNumberList.get(i) == computerNumberList.get(i)) {
                strikeCounting += 1;
            }
        }

        return strikeCounting;
    }

    public static int distinguishBall (List<Integer> inputNumberList, List<Integer> computerNumberList, int strikeCounting) {
        int ballCounting = 0;

        for (int i = 0; i < 3; i++) {
            if (computerNumberList.contains(inputNumberList.get(i))) {
                ballCounting += 1;
            }
        }

        return ballCounting - strikeCounting;
    }

    public static List<Integer> makeComputerNumber () {
        List<Integer> computerNumberList = new ArrayList<>();
        for (int j = 0; j < 3; j++) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumberList.contains(randomNumber)) {
                computerNumberList.add(randomNumber);
            }
        }
        return computerNumberList;
    }

    public static List<Integer> splitNumber (String inputNumber) {
        List<Integer> inputNumberList = new ArrayList<>();

        for (int k = 0; k < 3; k++) {
            inputNumberList.add(Character.getNumericValue(inputNumber.charAt(k)));
        }

        return inputNumberList;
    }


    public static void main(String[] args) {

        String inputNumber = Console.readLine();
        List<Integer> inputNumberList = splitNumber(inputNumber);
        List<Integer> computerNumberList = makeComputerNumber();

    }
}
