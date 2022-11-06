package baseball.domain;

import baseball.util.GamePrinter;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Baseball implements Game {

    private final List<Integer> computerNumbers = new ArrayList<>(BaseballGuide.NUMBER_LENGTH);
    private final List<Integer> playerNumbers = new ArrayList<>(BaseballGuide.NUMBER_LENGTH);

    @Override
    public void play() {
        GamePrinter.println("숫자 야구 게임을 시작합니다.");
        BallCount ballCount;
        String playerInput;
        generateComputerNumbers();
        do {
            playerInput = playerInput();
            generatePlayerNumbers(playerInput);
            ballCount = compareNumbers();
            ballCount.show();
        } while (ballCount.check());
        GamePrinter.println(BaseballGuide.NUMBER_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private void generateComputerNumbers() {
        computerNumbers.clear();
        computerNumbers.addAll(pickUniqueNumbers());
    }

    private List<Integer> pickUniqueNumbers() {
        Set<Integer> numbers = new LinkedHashSet<>();
        while (numbers.size() != BaseballGuide.NUMBER_LENGTH) {
            numbers.add(
                Randoms.pickNumberInRange(BaseballGuide.RANGE_START, BaseballGuide.RANGE_END));
        }
        return new ArrayList<>(numbers);
    }

    private String playerInput() {
        GamePrinter.print("숫자를 입력해주세요 : ");
        String playerInput = Console.readLine();
        BaseballGuide.Validator.validate(playerInput);
        return playerInput;
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
