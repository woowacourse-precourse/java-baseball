package baseball.view;

import baseball.model.strikeandball.StrikeAndBall;
import baseball.Application;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class ConsoleOutputTest extends NsTest {

    private Output output = new ConsoleOutput();

    @Test
    public void printStrikeandBall_메서드_사용시_strike_2_ball_0_인_경우_스트라이크_반환() {
        //given
        StrikeAndBall strikeAndBall = new StrikeAndBall(2, 0);

        //when
        output.printStrikeandBall(strikeAndBall);

        //then
        assertThat(output()).isEqualTo("2스트라이크");
    }

    @Test
    public void printStrikeandBall_메서드_사용시_strike_0_ball_3_인_경우_볼_반환() {
        //given
        StrikeAndBall strikeAndBall = new StrikeAndBall(0, 3);

        //when
        output.printStrikeandBall(strikeAndBall);

        //then
        assertThat(output()).isEqualTo("3볼");
    }

    @Test
    public void printStrikeandBall_메서드_사용시_strike_1_ball_1_인_경우_볼_스트라이크_반환() {
        //given
        StrikeAndBall strikeAndBall = new StrikeAndBall(1, 1);

        //when
        output.printStrikeandBall(strikeAndBall);

        //then
        assertThat(output()).isEqualTo("1볼 1스트라이크");
    }

    @Test
    public void printStrikeandBall_메서드_사용시_strike_0_ball_0_인_경우_낫싱_반환() {
        //given
        StrikeAndBall strikeAndBall = new StrikeAndBall(0, 0);

        //when
        output.printStrikeandBall(strikeAndBall);

        //then
        assertThat(output()).isEqualTo("낫싱");
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}