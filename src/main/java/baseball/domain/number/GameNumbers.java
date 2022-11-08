package baseball.domain.number;

import baseball.util.GameNumberConst;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameNumbers {

    private static final String WRONG_INPUT = "잘못된 입력입니다.";
    private static final String PLAYER_INPUT_SPLIT_VALUE = "";

    private final List<GameNumber> gameNumbers;

    /**
     * 컴퓨터 정답을 생성하는 기본 생성자
     */
    public GameNumbers() {
        Set<Integer> uniqueNumbers = new HashSet<>();

        while (uniqueNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(
                    GameNumberConst.MIN_GAME_NUMBER_VALUE,
                    GameNumberConst.MAX_GAME_NUMBER_VALUE);
            uniqueNumbers.add(randomNumber);
        }

        AtomicInteger index = new AtomicInteger();

        this.gameNumbers = uniqueNumbers.stream()
                .map(uniqueNumber -> new GameNumber(uniqueNumber, index.getAndIncrement()))
                .collect(Collectors.toList());
    }

    /**
     * 플레이어가 입력한 정답을 List GameNumber로 변환하는 생성자
     *
     * @param playerAnswer 플레이어가 입력한 정답 문자열
     */
    public GameNumbers(String playerAnswer) {
        validatePlayerAnswer(playerAnswer);

        this.gameNumbers = IntStream.range(0, GameNumberConst.MAX_GAME_NUMBER_SIZE)
                .mapToObj(index -> new GameNumber(playerAnswer.charAt(index), index))
                .collect(Collectors.toList());
    }

    private void validatePlayerAnswer(String playerAnswer) {
        if (!validateLength(playerAnswer) || duplicateString(playerAnswer)) {
            throw new IllegalArgumentException(WRONG_INPUT);
        }
    }

    private boolean validateLength(String playerAnswer) {
        return playerAnswer.length() == GameNumberConst.MAX_GAME_NUMBER_SIZE;
    }

    private boolean duplicateString(String playerAnswer) {
        return Arrays.stream(playerAnswer.split(PLAYER_INPUT_SPLIT_VALUE))
                .distinct()
                .count() != GameNumberConst.MAX_GAME_NUMBER_SIZE;
    }

    public long calculateStrike(GameNumbers playerAnswer) {
        return playerAnswer.gameNumbers.stream().filter(this::isStrike).count();
    }

    public long calculateBall(GameNumbers playerAnswer) {
        return playerAnswer.gameNumbers.stream().filter(this::isBall).count();
    }

    private boolean isStrike(GameNumber playerNumber) {
        return gameNumbers.stream().anyMatch(gameNumber -> gameNumber.equals(playerNumber));
    }

    private boolean isBall(GameNumber playerNumber) {
        return gameNumbers.stream().anyMatch(gameNumber -> gameNumber.equalsWithoutIndex(playerNumber));
    }
}
