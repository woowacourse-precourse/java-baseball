package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int opponentNum = generateOpponentNumber();


        return;
    }

    public static int generateOpponentNumber() {
        List<Integer> numList = new ArrayList<>();

        while (numList.size() != 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numList.contains(randomNumber)) {
                numList.add(randomNumber);
            }
        }

        int opponentNumber = numListToThreeDigits(numList);

        return opponentNumber;
    }


    private static List<Integer> threeDigitsToNumList(int number) {
        List<Integer> eachDigits = new ArrayList<>();
        for (int index = 0; index < 3; index++) {
            eachDigits.add(number % 10);
            number /= 10;
        }
        return eachDigits;
    }

    private static int numListToThreeDigits(List<Integer> eachDigits) {
        int threeDigits = 0;
        for (int index = 0; index < 2; index++) {
            threeDigits += eachDigits.get(index);
            threeDigits *= 10;
        }
        threeDigits += eachDigits.get(2);

        return threeDigits;
    }

}
