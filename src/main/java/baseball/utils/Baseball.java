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

    private static void validateBaseballNumber(LinkedHashSet<Integer> baseballNumber) throws IllegalArgumentException {
        long ballCnt = baseballNumber.stream().distinct().count();
        // LinkedHashSet 사용으로 서로 다른 숫자 검증부 생략
        if (ballCnt != TOTAL_BALL_CNT) {
            throw new IllegalArgumentException("Exception because of inputted Number: " + baseballNumber.toString());
        }
    }

    public static Baseball createComputer() {
        LinkedHashSet<Integer> computerBalls = new LinkedHashSet<>();

        while (computerBalls.size() < TOTAL_BALL_CNT) {
            computerBalls.add(Randoms.pickNumberInRange(1, 9));
        }

        Baseball computer = new Baseball(computerBalls);
        return computer;
    }

    public static Baseball createPlayer(String inputNumber) {
        LinkedHashSet<Integer> ballOfPlayer = new LinkedHashSet<>();
        int num;

        for (int i = 0; i < inputNumber.length(); i++) {
            num = Character.getNumericValue(inputNumber.charAt(i));
            ballOfPlayer.add(num);
        }
        validateBaseballNumber(ballOfPlayer);
        Baseball player = new Baseball(ballOfPlayer);
        return player;
    }
}
