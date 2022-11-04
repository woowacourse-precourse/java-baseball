package baseball.domain;

import baseball.util.GamePrinter;
import baseball.util.GameValidator;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BaseBall implements Game {

    private final List<Integer> computerNumbers;
    private final List<Integer> playerNumbers = new ArrayList<>(GameValidator.GAME_NUMBER_LENGTH);
    private int strike;
    private int ball;

    public BaseBall() {
        computerNumbers = Randoms.pickUniqueNumbersInRange((int) GameValidator.START_RANGE,
            (int) GameValidator.END_RANGE, GameValidator.GAME_NUMBER_LENGTH);
        resetGameStatus();
    }

    @Override
    public void play() {
        playerInput();
        compareNumbers();
        showResult();
    }

    private void playerInput() {
        String playerInput = Console.readLine();
        GameValidator.validate(playerInput);
        storePlayerNumbers(playerInput);
    }

    private void storePlayerNumbers(String playerInput) {
        playerNumbers.clear();
        playerNumbers.addAll(
            playerInput.chars()
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
            result.append(strike).append("스트라이크").append("\n");
        }

        if (strike == GameValidator.GAME_NUMBER_LENGTH) {
            result.append(GameValidator.GAME_NUMBER_LENGTH).append("개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }

        GamePrinter.println(result.toString());
    }

}
