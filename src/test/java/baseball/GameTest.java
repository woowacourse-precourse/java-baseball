package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class GameTest {
    static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    @Test
    void 시작_문구_출력_체크(){
        Game game = new Game();
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        game.printStartMessage();
        assertThat(out.toString()).isEqualTo(START_MESSAGE+"\n");
    }
    @Test
    void 컴퓨터가_생성한_숫자_조건체크(){
        Game game = new Game();
        List<Integer> result = game.createComputerNumber();

        assertThat(result.size()).isEqualTo(3);
        assertThat(result.get(0) != result.get(1)).isEqualTo(true);
        assertThat(result.get(0) != result.get(2)).isEqualTo(true);
        assertThat(result.get(1) != result.get(2)).isEqualTo(true);
    }

    @Test
    void 사용자_숫자_입력받기(){
        Game game = new Game();
        String userNumber = "123";

        InputStream in = new ByteArrayInputStream(userNumber.getBytes());
        System.setIn(in);
        List<Integer> user = game.inputUserNumber();
        assertThat(user.get(0)).isEqualTo(1);
        assertThat(user.get(1)).isEqualTo(2);
        assertThat(user.get(2)).isEqualTo(3);

    }
    @Test
    void 스트라이크_구하기1(){
        Game game = new Game();
        List<Integer> computer = Arrays.asList(4, 5, 6);
        List<Integer> user = Arrays.asList(4, 5, 6);
        assertThat(game.checkStrike(computer, user)).isEqualTo(3);
    }
    @Test
    void 스트라이크_구하기2(){
        Game game = new Game();
        List<Integer> computer = Arrays.asList(1, 5, 6);
        List<Integer> user = Arrays.asList(4, 1, 6);
        assertThat(game.checkStrike(computer, user)).isEqualTo(1);
    }
    @Test
    void 스트라이크_구하기3(){
        Game game = new Game();
        List<Integer> computer = Arrays.asList(1, 5, 7);
        List<Integer> user = Arrays.asList(4, 1, 6);
        assertThat(game.checkStrike(computer, user)).isEqualTo(0);
    }

    @Test
    void 볼_개수_구하기1(){
        Game game = new Game();
        List<Integer> computer = Arrays.asList(1, 5, 7);
        List<Integer> user = Arrays.asList(4, 1, 6);
        int strike = game.checkStrike(computer, user);
        assertThat(game.checkBall(computer, user, strike)).isEqualTo(1);
    }
    @Test
    void 볼_개수_구하기2(){
        Game game = new Game();
        List<Integer> computer = Arrays.asList(1, 5, 6);
        List<Integer> user = Arrays.asList(4, 1, 6);
        int strike = game.checkStrike(computer, user);
        assertThat(game.checkBall(computer, user, strike)).isEqualTo(1);
    }
    @Test
    void 볼_개수_구하기3(){
        Game game = new Game();
        List<Integer> computer = Arrays.asList(1, 5, 6);
        List<Integer> user = Arrays.asList(6, 1, 5);
        int strike = game.checkStrike(computer, user);
        assertThat(game.checkBall(computer, user, strike)).isEqualTo(3);
    }
    @Test
    void 볼_개수_구하기4(){
        Game game = new Game();
        List<Integer> computer = Arrays.asList(6, 1, 5);
        List<Integer> user = Arrays.asList(6, 1, 5);
        int strike = game.checkStrike(computer, user);
        assertThat(game.checkBall(computer, user, strike)).isEqualTo(0);
    }
}