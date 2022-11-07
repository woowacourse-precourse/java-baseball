package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RefereeTest {

    private Computer computer = Mockito.mock(Computer.class);
    private User user = Mockito.mock(User.class);
    private Referee referee = new Referee(computer, user);

    @Test
    @DisplayName("3스트라이크 판결 테스트")
    void judgeThreeStrikeTest() {
        when(computer.getNumbers()).thenReturn(List.of(1, 2, 3));
        when(user.getVerifiedValueList()).thenReturn(List.of(1, 2, 3));

        referee.judge();

        assertThat(referee.getStrike()).isEqualTo(3);
        assertThat(referee.getBall()).isZero();
    }

    @Test
    @DisplayName("1스트라이크 2볼 판결 테스트")
    void judgeOneStrikeTwoBallTest() {
        when(computer.getNumbers()).thenReturn(List.of(1, 2, 3));
        when(user.getVerifiedValueList()).thenReturn(List.of(1, 3, 2));

        referee.judge();

        assertThat(referee.getStrike()).isEqualTo(1);
        assertThat(referee.getBall()).isEqualTo(2);
    }

    @Test
    @DisplayName("1볼 판결 테스트")
    void judgeOneBallTest() {
        when(computer.getNumbers()).thenReturn(List.of(1, 2, 3));
        when(user.getVerifiedValueList()).thenReturn(List.of(4, 5, 1));

        referee.judge();

        assertThat(referee.getStrike()).isZero();
        assertThat(referee.getBall()).isEqualTo(1);
    }

    @Test
    @DisplayName("스트라이크 볼 초기화")
    void initTest() {
        referee.init();

        assertThat(referee.getStrike()).isZero();
        assertThat(referee.getBall()).isZero();
    }

}
