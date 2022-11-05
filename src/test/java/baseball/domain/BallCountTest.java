package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.util.GameValidator;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallCountTest {

    private OutputStream setSystemOut() {
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        return outputStream;
    }

    @DisplayName("스트라이크가 정해진 개수와 같다면 false 반환한다.")
    @Test
    void checkFalse() {
        //given
        BallCount ballCount = new BallCount(GameValidator.NUMBER_LENGTH, 0);

        //when
        boolean result = ballCount.check();

        //then
        assertThat(result).isFalse();
    }

    @DisplayName("스트라이크가 정해진 개수와 다르다면 true 반환한다.")
    @Test
    void checkTrue() {
        //given
        BallCount ballCount = new BallCount(GameValidator.NUMBER_LENGTH - 1, 0);

        //when
        boolean result = ballCount.check();

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("볼과 스트라이크가 존재하면 볼, 스트라이크 정보를 출력한다.")
    @Test
    void showBallAndStrike() throws IOException {
        //given
        BallCount ballCount = new BallCount(1, 1);
        OutputStream out = setSystemOut();
        String msg = "1볼 1스트라이크";

        //when
        ballCount.show();

        //then
        assertThat(out.toString()).isEqualTo(msg + "\n");
        out.close();
    }

    @DisplayName("볼만 존재하면 볼 정보를 출력한다.")
    @Test
    void showBall() throws IOException {
        //given
        BallCount ballCount = new BallCount(0, 1);
        OutputStream out = setSystemOut();
        String msg = "1볼";

        //when
        ballCount.show();

        //then
        assertThat(out.toString()).isEqualTo(msg + "\n");
        out.close();
    }

    @DisplayName("스트라이크만 존재하면 스트라이크 정보를 출력한다.")
    @Test
    void showStrike() throws IOException {
        //given
        BallCount ballCount = new BallCount(1, 0);
        OutputStream out = setSystemOut();
        String msg = "1스트라이크";

        //when
        ballCount.show();

        //then
        assertThat(out.toString()).isEqualTo(msg + "\n");
        out.close();
    }

    @DisplayName("스트라이크가 정해진 개수와 같다면 추가적인 정보를 출력한다.")
    @Test
    void showStrikeWithInfo() throws IOException {
        //given
        BallCount ballCount = new BallCount(GameValidator.NUMBER_LENGTH, 0);
        OutputStream out = setSystemOut();
        String msg = "3스트라이크";
        String info = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

        //when
        ballCount.show();

        //then
        assertThat(out.toString()).isEqualTo(msg + "\n" + info + "\n");
        out.close();
    }
}