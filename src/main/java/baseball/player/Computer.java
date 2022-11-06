package baseball.player;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer extends Player implements JudgeAble {
    private static final int HINT_INITIAL_VALUE = 0;
    private static final int BALL_INDEX = 0;
    private static final int STRIKE_INDEX = 1;

    public Computer(int randomNumber) {
        super(randomNumber);
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

