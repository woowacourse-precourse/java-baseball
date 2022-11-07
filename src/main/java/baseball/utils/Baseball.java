package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import static baseball.values.Constant.Digit.TOTAL_BALL_CNT;

public class Baseball {
    private final LinkedHashSet<Integer> baseballNumber;

    public Baseball(LinkedHashSet<Integer> baseballNumber) {
        this.baseballNumber = baseballNumber;
    }

    public List<Integer> getBaseballNumber() {
        return new ArrayList<>(baseballNumber);
    }

    private static void validateSameNumber(LinkedHashSet<Integer> balls) {
        long ballCnt = balls.stream().distinct().count();
        if (ballCnt != TOTAL_BALL_CNT) {
            throw new IllegalArgumentException("Exception because of inputted Number: " + balls.toString());
        }
    }

    private static void validateInputNumberCnt(String inputNumber) {
        if (inputNumber.length() != TOTAL_BALL_CNT){
            throw new IllegalArgumentException("Exception because of inputted Number: " + inputNumber);
        }
    }

    public static Baseball createComputer() {
        LinkedHashSet<Integer> computerBalls = new LinkedHashSet<>();

        while (computerBalls.size() < TOTAL_BALL_CNT) {
            computerBalls.add(Randoms.pickNumberInRange(1, 9));
        }
        return new Baseball(computerBalls);
    }

    public static Baseball createPlayer(String inputNumber) {
        LinkedHashSet<Integer> playerBalls = new LinkedHashSet<>();
        int num;
        validateInputNumberCnt(inputNumber);
        for (int i = 0; i < inputNumber.length(); i++) {
            num = Character.getNumericValue(inputNumber.charAt(i));
            playerBalls.add(num);
        }
        validateSameNumber(playerBalls);
        return new Baseball(playerBalls);
    }
}
