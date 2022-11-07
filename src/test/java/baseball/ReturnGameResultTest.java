package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ReturnGameResultTest extends NsTest {
    ReturnGameResult returnGameResult = new ReturnGameResult();

    @Test
    void 모든_번호_맞췄을_경우() {
        boolean threeStrike = returnGameResult.printResult(3, 0);
        assertThat(threeStrike).isEqualTo(false);
        assertThat(output()).contains("3스트라이크", "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    @Test
    void 맞는_부분이_없을_경우() {
        boolean nothing = returnGameResult.printResult(0, 0);
        assertThat(nothing).isEqualTo(true);
        assertThat(output()).contains("낫싱");
    }

    @Test
    void 스트라이크만_있는_경우() {
        boolean justStrike = returnGameResult.printResult(2, 0);
        assertThat(justStrike).isEqualTo(true);
        assertThat(output()).contains("2스트라이크");
    }

    @Test
    void 볼만_있는_경우() {
        boolean justBall = returnGameResult.printResult(0, 2);
        assertThat(output()).contains("2볼");
    }

    @Test
    void 스트라이크와_볼_전부_있는_경우() {
        boolean strikeAndBall = returnGameResult.printResult(1, 1);
        assertThat(strikeAndBall).isEqualTo(true);
        assertThat(output()).contains("1볼 1스트라이크");
    }

    @Override
    protected void runMain() {
    }
}