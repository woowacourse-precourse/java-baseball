package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;


public class Application {

    public static List<Integer> createRandomNumber(List<Integer> computer) {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> inputUserNumber() {
        List<Integer> userInputNumber = new ArrayList<>();
        String inputNumber = readLine();
        String[] inputNumberSplitArray = inputNumber.split("");
        for (int i = 0; i < inputNumberSplitArray.length; i++)
        {
            userInputNumber.add(Integer.parseInt(inputNumberSplitArray[i]));
        }

        return userInputNumber;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> computerCreateNumber = new ArrayList<>();
        List<Integer> userInputNumber = new ArrayList<>();

    }
}

