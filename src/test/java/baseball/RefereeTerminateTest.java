package baseball;

import baseball.participants.Referee;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTerminateTest extends NsTest {
    @Test
    void testPlayAgain() {
        run("4", "1");
        assertThat(output()).contains("1 혹은 2만 입력해주세요.", "게임을 다시 시작합니다.");
    }

    @Test
    void testTerminateGame() {
        run("4", "2");
        assertThat(output()).contains("1 혹은 2만 입력해주세요.", "게임을 완전히 종료합니다.");
    }

    @Override
    protected void runMain() {
        Referee referee = new Referee();
        referee.playAgainOrNot();
    }
}
