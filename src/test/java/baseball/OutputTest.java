package baseball;

import baseball.domain.StrikeAndBallDomain;
import baseball.domain.game.GameMessage;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OutputTest extends NsTest {
    private StrikeAndBallDomain strikeAndBallDomain;

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @BeforeEach
    public void each() {
        strikeAndBallDomain = new StrikeAndBallDomain();
    }

    @Test
    public void 출력_낫싱_테스트() {
        String expectOutput = GameMessage.NOTHING.getMassage();
        checkExpect(0, 0, expectOutput);
    }

    @Test
    public void 출력_3스트라이크_테스트() {
        String expectOutput = GameMessage.THREE_STRIKE.getMassage();
        checkExpect(0, 3, expectOutput);
    }

    @Test
    public void 출력_0볼_1스트라이크_테스트() {
        String expectOutput = "0볼 1스트라이크";
        checkExpect(0, 1, expectOutput);
    }

    @Test
    public void 출력_0볼_2스트라이크_테스트() {
        String expectOutput = "0볼 2스트라이크";
        checkExpect(0, 2, expectOutput);
    }

    @Test
    public void 출력_1볼_0스트라이크_테스트() {
        String expectOutput = "1볼 0스트라이크";
        checkExpect(1, 0, expectOutput);
    }

    @Test
    public void 출력_1볼_1스트라이크_테스트() {
        String expectOutput = "1볼 1스트라이크";
        checkExpect(1, 1, expectOutput);
    }

    @Test
    public void 출력_2볼_0스트라이크_테스트() {
        String expectOutput = "2볼 0스트라이크";
        checkExpect(2, 0, expectOutput);
    }

    @Test
    public void 출력_2볼_1스트라이크_테스트() {
        String expectOutput = "2볼 1스트라이크";
        checkExpect(2, 1, expectOutput);
    }

    private void checkExpect(int ball, int strike, String expect) {
        GameMessage.BALL_AND_STRIKE.setMassage("%d볼 %d스트라이크\n");
        strikeAndBallDomain.setBall(ball);
        strikeAndBallDomain.setStrike(strike);
        GameMessage gameMessage = GameMessage.findStrikeAndBallMessage(strikeAndBallDomain);
        assertThat(gameMessage.getMassage().trim()).isEqualTo(expect.trim());
    }
}