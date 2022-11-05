package baseball.domain;

import baseball.util.GamePrinter;
import baseball.util.GameValidator;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BaseBall implements Game {

    private final List<Integer> computerNumbers = new ArrayList<>(GameValidator.NUMBER_LENGTH);
    private final List<Integer> playerNumbers = new ArrayList<>(GameValidator.NUMBER_LENGTH);

    @Override
    public void play() {
        GamePrinter.println("숫자 야구 게임을 시작합니다.");
        BallCount ballCount;
        generateRandomComputerNumbers();
        do {
            playerInput();
            ballCount = compareNumbers();
            ballCount.show();
        } while (ballCount.check());
    }

    private void generateRandomComputerNumbers() {
        computerNumbers.clear();
        computerNumbers.addAll(pickUniqueNumbersInRange());
    }

    private List<Integer> pickUniqueNumbersInRange() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() != GameValidator.NUMBER_LENGTH) {
            numbers.add(
                Randoms.pickNumberInRange(GameValidator.RANGE_START, GameValidator.RANGE_END));
        }
        return new ArrayList<>(numbers);
    }

    private void playerInput() {
        GamePrinter.print("숫자를 입력해주세요 : ");
        String playerInput = Console.readLine();
        GameValidator.validate(playerInput);
        generatePlayerNumbers(playerInput);
    }

    private void generatePlayerNumbers(String playerInput) {
        playerNumbers.clear();
        playerNumbers.addAll(
            playerInput.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList())
        );
    }

    private BallCount compareNumbers() {
        int strike = (int) IntStream.range(0, playerNumbers.size())
            .filter(this::isStrike)
            .count();
        int ball = (int) IntStream.range(0, playerNumbers.size())
            .filter(index -> !isStrike(index) && isBall(index))
            .count();
        return new BallCount(strike, ball);
    }

    private boolean isStrike(int index) {
        return Objects.equals(computerNumbers.get(index), playerNumbers.get(index));
    }

    private boolean isBall(int index) {
        return computerNumbers.contains(playerNumbers.get(index));
    }

}
