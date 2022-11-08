package baseball.Util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class RandomNumber {

    public static ArrayList<Integer> setRandomNumber() {
        ArrayList<Integer> answerNumber = new ArrayList<>();
        answerNumber = allocateRandomNumber(answerNumber);
        return answerNumber;
    }

    private static ArrayList<Integer> allocateRandomNumber(ArrayList<Integer> answerNumber) {
        while (answerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (verifyAnswerNumber(answerNumber, randomNumber))
                continue;
            answerNumber.add(randomNumber);
        }
        return answerNumber;
    }

    private static boolean verifyAnswerNumber(ArrayList<Integer> answerNumber, int randomNumber) {
        if (answerNumber.contains(randomNumber)) {
            return true;
        }
        return false;
    }
}
