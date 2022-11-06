package baseball;

import baseball.participants.Pitcher;
import baseball.participants.Referee;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PitcherInputTest extends NsTest {
    @Test
    void testPitch() {
        run("245");
        assertThat(output()).contains("3자리 숫자를 입력해주세요 :", "245");
    }

    @Override
    protected void runMain() {
        Referee referee = new Referee();
        Pitcher pitcher = new Pitcher();
        referee.startPitch();
        pitcher.pitch();
        System.out.println(pitcher.pitchZone.toString());
    }
}
