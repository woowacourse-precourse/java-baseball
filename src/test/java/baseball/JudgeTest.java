package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedHashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JudgeTest {
    Judge judge;
    LinkedHashMap<Integer, Integer> computerNumbers = new LinkedHashMap<>();
    LinkedHashMap<Integer, Integer> playerNumbers = new LinkedHashMap<>();

    @BeforeEach
    public void setUp() {
        judge = new Judge();

        // 컴퓨터 숫자 246
        computerNumbers.put(0, 2);
        computerNumbers.put(1, 4);
        computerNumbers.put(2, 6);

        // 플레이어 숫자 267
        playerNumbers.put(0, 2);
        playerNumbers.put(1, 6);
        playerNumbers.put(2, 7);
    }

    @Test
    @DisplayName("스트라이크 개수 구하는 기능 테스트")
    public void countStrike() {
        int strikeCount;
        strikeCount = judge.countStrike(computerNumbers, playerNumbers);
        assertThat(strikeCount).isEqualTo(1);
    }

    @Test
    @DisplayName("깉은 값의 개수를 자리에 관계없이 모두 구하는 기능 테스트")
    public void countSameNumber() {
        int sameNumberCount;
        sameNumberCount = judge.countSameNumber(computerNumbers, playerNumbers);
        assertThat(sameNumberCount).isEqualTo(2);
    }

    @Test
    @DisplayName("힌트 출력 기능 테스트")
    public void printGameOver() {
        int strikeCount = judge.countStrike(computerNumbers, playerNumbers);
        int sameNumberCount = judge.countSameNumber(computerNumbers, playerNumbers);
        int ballCount = sameNumberCount - strikeCount;

        String hint = judge.printHint(strikeCount, ballCount);
        assertThat(hint.equals("1볼 1스트라이크")).isTrue();
    }
}
