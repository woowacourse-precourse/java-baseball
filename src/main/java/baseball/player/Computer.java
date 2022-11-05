package baseball.player;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer extends Player implements JudgeAble {
    private static final int NUMBER_SIZE = 3;
    private static final int RANDOM_NUMBER_START = 1;
    private static final int RANDOM_NUMBER_END = 9;
    private static final int HINT_INITIAL_VALUE = 0;
    private static final int BALL_INDEX = 0;
    private static final int STRIKE_INDEX = 1;

    public static int makeRandomNumber() {
        List<Integer> randomNumberList = new ArrayList<>();
        while (randomNumberList.size() < NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(RANDOM_NUMBER_START, RANDOM_NUMBER_END);
            if (!randomNumberList.contains(randomNumber)) {
                randomNumberList.add(randomNumber);
            }
        }
        StringBuffer randomNumber = convertListToStringBuffer(randomNumberList);
        return Integer.parseInt(randomNumber.toString());
    }

    private static StringBuffer convertListToStringBuffer(List<Integer> randomNumberList) {
        StringBuffer randomNumber = new StringBuffer();
        for (Integer i : randomNumberList) {
            randomNumber.append(i);
        }
        return randomNumber;
    }

    @Override
    public List<Integer> judge(int number) {
        String baseNumber = String.valueOf(super.getNumber());
        String compareNumber = String.valueOf(number);
        List<String> containNumbers = filterContainNumbers(baseNumber, compareNumber);
        List<Integer> hints = judgeCount(baseNumber, compareNumber, containNumbers);
        return hints;
    }

    private List<String> filterContainNumbers(String baseNumber, String compareNumber) {
        ArrayList<String> containNumbers = new ArrayList<>();
        for (String number : compareNumber.split("")) {
            if (baseNumber
                    .contains(number)) {
                containNumbers.add(number);
            }
        }
        return containNumbers;
    }

    private List<Integer> judgeCount(String baseNumber, String compareNumber, List<String> containNumbers) {
        ArrayList<Integer> hints = new ArrayList<>(List.of(HINT_INITIAL_VALUE, HINT_INITIAL_VALUE));
        for (String containNumber : containNumbers) {
            if (baseNumber
                    .indexOf(containNumber)
                    ==
                    compareNumber
                            .indexOf(containNumber)) {
                hints.set(STRIKE_INDEX, hints.get(STRIKE_INDEX) + 1);
            } else {
                hints.set(BALL_INDEX, hints.get(BALL_INDEX) + 1);
            }
        }
        return hints;
    }
}

