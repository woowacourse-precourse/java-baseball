package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumber {
    private static final int MAX_LENGTH = 3;

    private List<Integer> numbers;

    public BaseballNumber(String input) {
        String[] strings = input.split("");

        // 사용자가 잘못된 값을 입력할 경우
        if (strings.length != MAX_LENGTH) {
            throw new IllegalArgumentException();
        }

        List<Integer> user = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            // 숫자가 아닌 다른값을 입력할 경우
            try {
                user.add(Integer.parseInt(strings[i]));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }

        Set<Integer> set = new HashSet<>(user);

        if (set.size() != MAX_LENGTH) {
            throw new IllegalArgumentException();
        }

        this.numbers = user;
    }

    public BaseballNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < MAX_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        this.numbers = computer;
    }

    public int getStrike(BaseballNumber other) {
        int strike = 0;
        for (int i = 0; i < MAX_LENGTH; i++) {
            if (numbers.get(i) == other.numbers.get(i)) {
                ++strike;
            }
        }
        return strike;
    }

    public int getBall(BaseballNumber other) {
        int ball = 0;
        for (int i = 0; i < MAX_LENGTH; i++) {
            int otherNumber = other.numbers.get(i);

            if (numbers.contains(otherNumber) && numbers.get(i) != otherNumber) {
                ++ball;
            }
        }
        return ball;
    }
}
