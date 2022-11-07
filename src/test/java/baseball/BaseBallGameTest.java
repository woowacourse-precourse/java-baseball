package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseBallGameTest {
    BaseBallGame baseBallGame = new BaseBallGame();
    @Test
    void 유저_숫자_입력_테스트() {
        //given
        String userNumber = "123";
        InputStream in = new ByteArrayInputStream(userNumber.getBytes());
        System.setIn(in);
        //when
        baseBallGame.inputUserNumber();
        //then
        assertThat(baseBallGame.getUserNumber()).isEqualTo(userNumber);
    }

    @Test
    void 유저_숫자가_컴퓨터_숫자와_일치_테스트() {
        //given
        List<Integer> randomNumber = baseBallGame.getComputer().getRandomNumber();
        String strRandomNumber = randomNumber.toString().replaceAll("[^0-9]","");
        InputStream in = new ByteArrayInputStream(strRandomNumber.getBytes());
        System.setIn(in);
        //when
        baseBallGame.inputUserNumber();
        int isEqual = baseBallGame.isEqualToComputerNumber();
        //then
        assertThat(isEqual).isEqualTo(1);
    }

    @Test
    void 스트라이크_개수_확인() {
        //given
        List<Integer> randomNumber = baseBallGame.getComputer().getRandomNumber();
        String strRandomNumber = randomNumber.toString().replaceAll("[^0-9]","");
        InputStream in = new ByteArrayInputStream(strRandomNumber.getBytes());
        System.setIn(in);
        //when
        baseBallGame.inputUserNumber();
        baseBallGame.countStrikeCount();
        //then
        assertThat(baseBallGame.getStrikeCount()).isEqualTo(3);
    }

    @Test
    void 볼_개수_확인() {
        //given
        List<Integer> randomNumber = baseBallGame.getComputer().getRandomNumber();
        String strRandomNumber = randomNumber.toString().replaceAll("[^0-9]","");
        InputStream in = new ByteArrayInputStream(strRandomNumber.getBytes());
        System.setIn(in);
        //when
        baseBallGame.inputUserNumber();
        baseBallGame.countBallCount();
        //then
        assertThat(baseBallGame.getBallCount()).isEqualTo(0);
    }

    @Test
    void 재시작_토큰_예외처리() {
        //given
        String testToken = "0";
        InputStream in = new ByteArrayInputStream(testToken.getBytes());
        System.setIn(in);
        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            baseBallGame.setRestartToken();
        });
    }

    @Test
    void 유저_입력_길이_테스트() {
        //given
        String userNumber = "1234";
        InputStream in = new ByteArrayInputStream(userNumber.getBytes());
        System.setIn(in);
        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            baseBallGame.inputUserNumber();
        });
    }

    @Test
    void 유저_입력_숫자_테스트() {
        //given
        String userNumber = "1a4";
        InputStream in = new ByteArrayInputStream(userNumber.getBytes());
        System.setIn(in);
        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            baseBallGame.inputUserNumber();
        });
    }

    @Test
    void 유저_입력_중복_테스트() {
        //given
        String userNumber = "112";
        InputStream in = new ByteArrayInputStream(userNumber.getBytes());
        System.setIn(in);
        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            baseBallGame.inputUserNumber();
        });
    }

    @Test
    void 유저_입력_범위_테스트() {
        //given
        String userNumber = "103";
        InputStream in = new ByteArrayInputStream(userNumber.getBytes());
        System.setIn(in);
        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            baseBallGame.inputUserNumber();
        });
    }
}
