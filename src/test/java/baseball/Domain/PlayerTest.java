package baseball.Domain;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {
    Player player = new Player();

    @Test
    public void 플레이어_입력_테스트() {
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        player.insertPlayerNumbers();
        List<Integer> inputTest = List.of(1, 2, 3);
        assertThat(player.getPlayerGameNumbers()).isEqualTo(inputTest);
    }

    @Test
    public void 플레이어_입력숫자_길이_예외_테스트() {
        String input = "1234";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> player.insertPlayerNumbers());
    }

    @Test
    public void 플레이어_입력숫자_빈값_예외_테스트() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    player.insertPlayerNumbers();
                });
    }

    @Test
    public void 플레이어_입력숫자_중복_테스트() {
        String input = "991";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    player.insertPlayerNumbers();
                });
    }

    @Test
    public void 플레이어_게임_재시작_입력값_테스트() {
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThat(player.getAnswerAboutRestart()).isEqualTo(1);
    }

    @Test
    public void 플래이어_게임_재시작_입력값_에와테스트() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    player.getAnswerAboutRestart();
                });
    }

}

