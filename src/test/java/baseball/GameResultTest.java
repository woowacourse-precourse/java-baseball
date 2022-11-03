package baseball;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameResultTest {

    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String END_GAME_PHRASE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    GameResult gameResult;

    @BeforeEach
    void createGameResult() {
        gameResult = new GameResult();
    }

    @Test
    void ONE_스트라이크_판단_검증() {
        List<Integer> computerNumbers = new ArrayList<>();
        computerNumbers.add(1);
        computerNumbers.add(8);
        computerNumbers.add(4);
        List<Integer> answer = List.of(1, 3, 9);
        String oneStrike = 1 + STRIKE;

        String result = gameResult.getGameResult(computerNumbers, answer);
        Assertions.assertThat(result).isEqualTo(oneStrike);
    }

    @Test
    void THREE_스트라이크_판단_검증() {
        List<Integer> computerNumbers = new ArrayList<>();
        computerNumbers.add(1);
        computerNumbers.add(3);
        computerNumbers.add(9);
        List<Integer> answer = List.of(1, 3, 9);
        String threeStrike = 3 + STRIKE + System.lineSeparator() + END_GAME_PHRASE;

        String result = gameResult.getGameResult(computerNumbers, answer);
        Assertions.assertThat(result).isEqualTo(threeStrike);
    }

    @Test
    void ONE_볼_판단_검증() {
        List<Integer> computerNumbers = new ArrayList<>();
        computerNumbers.add(2);
        computerNumbers.add(9);
        computerNumbers.add(8);
        List<Integer> answer = List.of(1, 3, 9);
        String oneBall = 1 + BALL;

        String result = gameResult.getGameResult(computerNumbers, answer);
        Assertions.assertThat(result).isEqualTo(oneBall);
    }

    @Test
    void ONE_볼_ONE_스트라이크_판단_검증() {
        List<Integer> computerNumbers = new ArrayList<>();
        computerNumbers.add(1);
        computerNumbers.add(3);
        computerNumbers.add(2);
        List<Integer> answer = List.of(1, 4, 3);
        String oneBallOneStrike = 1 + BALL + " " + 1 + STRIKE;

        String result = gameResult.getGameResult(computerNumbers, answer);
        Assertions.assertThat(result).isEqualTo(oneBallOneStrike);
    }

    @Test
    void 낫싱_판단_검증() {
        List<Integer> computerNumbers = new ArrayList<>();
        computerNumbers.add(1);
        computerNumbers.add(2);
        computerNumbers.add(3);
        List<Integer> answer = List.of(4, 5, 6);
        String nothing = NOTHING;

        String result = gameResult.getGameResult(computerNumbers, answer);
        Assertions.assertThat(result).isEqualTo(nothing);
    }
}