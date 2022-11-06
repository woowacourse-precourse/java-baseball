package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

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
        BallCount ballCount = new BallCount(BaseballGuide.NUMBER_LENGTH, 0);

        //when
        boolean result = ballCount.check();

        //then
        assertThat(result).isFalse();
    }

    @DisplayName("스트라이크가 정해진 개수와 다르다면 true 반환한다.")
    @Test
    void checkTrue() {
        //given
        BallCount ballCount = new BallCount(BaseballGuide.NUMBER_LENGTH - 1, 0);

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
        String message = "1볼 1스트라이크\n";

        //when
        ballCount.show();

        //then
        assertThat(out.toString()).isEqualTo(message);
        out.close();
    }

    @DisplayName("볼만 존재하면 볼 정보를 출력한다.")
    @Test
    void showBall() throws IOException {
        //given
        BallCount ballCount = new BallCount(0, 1);
        OutputStream out = setSystemOut();
        String message = "1볼\n";

        //when
        ballCount.show();

        //then
        assertThat(out.toString()).isEqualTo(message);
        out.close();
    }

    @DisplayName("스트라이크만 존재하면 스트라이크 정보를 출력한다.")
    @Test
    void showStrike() throws IOException {
        //given
        BallCount ballCount = new BallCount(1, 0);
        OutputStream out = setSystemOut();
        String message = "1스트라이크\n";

        //when
        ballCount.show();

        //then
        assertThat(out.toString()).isEqualTo(message);
        out.close();
    }

    @DisplayName("볼, 스트라이크가 존재하지 않으면 없음을 알리는 정보를 출력한다.")
    @Test
    void showNothing() throws IOException {
        //given
        BallCount ballCount = new BallCount(0, 0);
        OutputStream out = setSystemOut();
        String message = "낫싱\n";

        //when
        ballCount.show();

        //then
        assertThat(out.toString()).isEqualTo(message);
        out.close();
    }

}