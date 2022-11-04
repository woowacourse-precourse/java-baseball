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
    private int strike;
    private int ball;

    public BaseBall() {
        resetGameStatus();
    }

    @Override
    public void play() {
        GamePrinter.println("숫자 야구 게임을 시작합니다.");
        generateRandomComputerNumbers();
        do {
            playerInput();
            compareNumbers();
            showResult();
        } while (isNotMatchNumbers());
    }

    private boolean isNotMatchNumbers() {
        return strike != GameValidator.NUMBER_LENGTH;
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
        storePlayerNumbers(playerInput);
    }

    private void storePlayerNumbers(String playerInput) {
        playerNumbers.clear();
        playerNumbers.addAll(
            playerInput.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList())
        );
    }

    private void compareNumbers() {
        resetGameStatus();
        IntStream.range(0, playerNumbers.size())
            .forEach(this::storeGameStatus);
    }

    private void resetGameStatus() {
        strike = 0;
        ball = 0;
    }

    private void storeGameStatus(int index) {
        if (isStrike(index)) {
            strike += 1;
        }

        if (!isStrike(index) && isBall(index)) {
            ball += 1;
        }
    }

    private boolean isStrike(int index) {
        return Objects.equals(computerNumbers.get(index), playerNumbers.get(index));
    }

    private boolean isBall(int index) {
        return computerNumbers.contains(playerNumbers.get(index));
    }

    private void showResult() {
        StringBuilder result = new StringBuilder();
        if (ball == 0 && strike == 0) {
            result.append("낫싱");
        }

        if (ball != 0) {
            result.append(ball).append("볼").append(" ");
        }

        if (strike != 0) {
            result.append(strike).append("스트라이크");
        }

        if (strike == GameValidator.NUMBER_LENGTH) {
            result.append("\n").append(GameValidator.NUMBER_LENGTH)
                .append("개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }

        GamePrinter.println(result.toString());
    }

}
