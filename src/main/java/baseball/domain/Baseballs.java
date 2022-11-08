package baseball.domain;

import baseball.utils.RandomGenerator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Baseballs {
    private static final int NECESSARY_BALL_NUMBER = 3;
    private static final int FIRST_BALL_INDEX = 0;
    private static final int LAST_BALL_INDEX = 2;

    private final List<Baseball> baseballs;

    private Baseballs(List<Baseball> baseballs) {
        this.baseballs = baseballs;
    }

    public static Baseballs generateRandomBaseballNumbers() {
        Set<Integer> randomNumbers = new HashSet<>();

        while (pickedThreeBalls(randomNumbers)) {
            int randomNumber = RandomGenerator.generateRandomNumber();
            randomNumbers.add(randomNumber);
        }
        List<Baseball> balls = randomNumbers.stream()
                .map(Baseball::of)
                .collect(Collectors.toList());
        return new Baseballs(balls);
    }

    public static Baseballs generateInputBaseballNumbers(List<Integer> baseballNumbers) {
        validate(baseballNumbers);
        List<Baseball> baseballs = baseballNumbers.stream()
                .map(Baseball::of)
                .collect(Collectors.toList());
        return new Baseballs(baseballs);
    }

    private static void validate(List<Integer> baseballNumbers) {
        int distinctCounts = (int) baseballNumbers.stream()
                .distinct()
                .count();
        if (distinctCounts != NECESSARY_BALL_NUMBER) {
            throw new IllegalArgumentException(
                    String.format("중복된 야구 번호가 존재합니다. 중복 제외 개수: %d", distinctCounts));
        }
    }

    private static boolean pickedThreeBalls(Set<Integer> randomNumbers) {
        return randomNumbers.size() != NECESSARY_BALL_NUMBER;
    }

    public int judgeStrikeCounts(Baseballs userBaseballs) {
        return (int) IntStream.rangeClosed(FIRST_BALL_INDEX, LAST_BALL_INDEX)
                .filter(index -> isStrike(index, userBaseballs))
                .count();
    }

    private boolean isStrike(int index, Baseballs userBaseballs) {
        Baseball baseball = this.baseballs.get(index);
        Baseball userBaseball = userBaseballs.baseballs.get(index);
        return baseball.equals(userBaseball);
    }

    public int judgeBallCounts(Baseballs userBaseballs) {
        return (int) IntStream.rangeClosed(FIRST_BALL_INDEX, LAST_BALL_INDEX)
                .filter(index -> isBall(index, userBaseballs))
                .count();
    }

    private boolean isBall(int index, Baseballs userBaseballs) {
        Baseball baseball = this.baseballs.get(index);
        Baseball userBaseball = userBaseballs.baseballs.get(index);
        return !baseball.equals(userBaseball) && this.baseballs.contains(userBaseball);
    }
}
