package baseball.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GameServiceTest {
    @Test()
    public void 입력받은_숫자와_생성된_숫자가_같은지_확인한다_true() {
        GameService.computer.number = 923;
        GameService.user.number = 923;
        boolean result = GameService.checkFinish();
        boolean expected = true;
        assertThat(result).isEqualTo(expected);
    }

    @Test()
    public void 입력받은_숫자와_생성된_숫자가_같은지_확인한다_false() {
        GameService.computer.number = 923;
        GameService.user.number = 913;
        boolean result = GameService.checkFinish();
        boolean expected = false;
        assertThat(result).isEqualTo(expected);
    }

    @Test()
    public void 스트라이크의_개수를_계산한다() {
        int computerNumber = 234;
        int userNumber = 124;
        int strike = GameService.getStrikeNumber(userNumber, computerNumber);
        assertEquals(1, strike);
    }

    @Test()
    public void 볼의_개수를_계산한다() {
        int computerNumber = 234;
        int userNumber = 124;
        int ball = GameService.getBallNumber(userNumber, computerNumber);
        assertEquals(1, ball);
    }

    @Test()
    public void 계산한_결과를_출력한다_1() {
        int strike = 1;
        int ball = 1;
        String result = GameService.printGameScore(strike, ball);
        String expected = "1볼 1스트라이크";
        assertThat(result).isEqualTo(expected);
    }

    @Test()
    public void 계산한_결과를_출력한다_2() {
        int strike = 0;
        int ball = 0;
        String result = GameService.printGameScore(strike, ball);
        String expected = "낫싱";
        assertThat(result).isEqualTo(expected);
    }

    @Test()
    public void 계산한_결과를_출력한다_3() {
        int strike = 0;
        int ball = 2;
        String result = GameService.printGameScore(strike, ball);
        String expected = "2볼";
        assertThat(result).isEqualTo(expected);
    }

    @Test()
    public void 계산한_결과를_출력한다_4() {
        int strike = 2;
        int ball = 0;
        String result = GameService.printGameScore(strike, ball);
        String expected = "2스트라이크";
        assertThat(result).isEqualTo(expected);
    }


}