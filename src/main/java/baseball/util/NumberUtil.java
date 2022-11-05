package baseball.util;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.view.Print.*;

public class NumberUtil {
    public static List<Integer> createRandomNumber() {
        List<Integer> answerList = new ArrayList<>();

        while (answerList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerList.contains(randomNumber)) {
                answerList.add(randomNumber);
            }
        }

        return answerList;
    }

    public static List<Integer> getUserNumber() {
        List<Integer> answerList = new ArrayList<>();

        printInputNumber();

        String inputNumber = Console.readLine();
        answerList = stringToList(inputNumber);

        return answerList;
    }

    public static List<Integer> stringToList(String inputNumber) {
        List<Integer> answerList = new ArrayList<>();

        for (int index = 0; index < inputNumber.length(); index++) {
            answerList.add(Character.getNumericValue(inputNumber.charAt(index)));
        }

        return answerList;
    }
}
