package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class NumberGenerator {

    private static final int LIMITED_NUMBER_SIZE = 3;
    private static final int FIRST_NUMBER = 1;
    private static final int FINAL_NUMBER = 9;

    private NumberGenerator() {
    }

    public static List<Integer> createGameNumbers() {
        final Set<Integer> gameNumbers = new LinkedHashSet<>();
        while (gameNumbers.size() < LIMITED_NUMBER_SIZE) {
            final int randomNumber = getRandomNumber();
            gameNumbers.add(randomNumber);
        }
        return new ArrayList<>(gameNumbers);
    }

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(FIRST_NUMBER, FINAL_NUMBER);
    }
}
