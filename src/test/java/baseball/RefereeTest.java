package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static baseball.Hint.*;
import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {
    private Referee referee;
    private List<Integer> catcherNumbers = List.of(1, 2, 3);

    @BeforeEach
    void init() {
        referee = new Referee();
    }

    @Test
    @DisplayName("심판을 힌트를 생성한다. - 낫싱")
    void generateHintForNothing() {
        List<Integer> pitcherNumbers = List.of(4, 5, 6);
        Hint hint = referee.getHint(catcherNumbers, pitcherNumbers);
        assertThat(hint).isEqualTo(NOTHING);
    }


    @Test
    @DisplayName("심판을 힌트를 생성한다. - 3스트라이크")
    void generateHintFor3Strike() {
        List<Integer> pitcherNumbers = List.of(1, 2, 3);
        Hint hint = referee.getHint(catcherNumbers, pitcherNumbers);
        assertThat(hint).isEqualTo(S3);
    }

    @Test
    @DisplayName("심판을 힌트를 생성한다. - 2스트라이크")
    void generateHintFor2Strike() {
        List<Integer> pitcherNumbers = List.of(1, 2, 4);
        Hint hint = referee.getHint(catcherNumbers, pitcherNumbers);
        assertThat(hint).isEqualTo(S2);
    }

    @Test
    @DisplayName("심판을 힌트를 생성한다. - 1스트라이크")
    void generateHintFor1Strike() {
        List<Integer> pitcherNumbers = List.of(1, 4, 5);
        Hint hint = referee.getHint(catcherNumbers, pitcherNumbers);
        assertThat(hint).isEqualTo(S1);
    }

    @Test
    @DisplayName("심판을 힌트를 생성한다. - 3볼")
    void generateHintFor3Ball() {
        List<Integer> pitcherNumbers = List.of(3, 1, 2);
        Hint hint = referee.getHint(catcherNumbers, pitcherNumbers);
        assertThat(hint).isEqualTo(B3);
    }

    @Test
    @DisplayName("심판을 힌트를 생성한다. - 2볼")
    void generateHintFor2Ball() {
        List<Integer> pitcherNumbers = List.of(4, 1, 2);
        Hint hint = referee.getHint(catcherNumbers, pitcherNumbers);
        assertThat(hint).isEqualTo(B2);
    }

    @Test
    @DisplayName("심판을 힌트를 생성한다. - 1볼")
    void generateHintFor1Ball() {
        List<Integer> pitcherNumbers = List.of(3, 4, 5);
        Hint hint = referee.getHint(catcherNumbers, pitcherNumbers);
        assertThat(hint).isEqualTo(B1);
    }

    @Test
    @DisplayName("심판을 힌트를 생성한다. - 1볼 1스트라이크")
    void generateHintFor1Ball1Strike() {
        List<Integer> pitcherNumbers = List.of(3, 2, 4);
        Hint hint = referee.getHint(catcherNumbers, pitcherNumbers);
        assertThat(hint).isEqualTo(B1S1);
    }

    @Test
    @DisplayName("심판을 힌트를 생성한다. - 2볼 1스트라이크")
    void generateHintFor1Ball2Strike() {
        List<Integer> pitcherNumbers = List.of(2, 1, 3);
        Hint hint = referee.getHint(catcherNumbers, pitcherNumbers);
        assertThat(hint).isEqualTo(B2S1);
    }
}