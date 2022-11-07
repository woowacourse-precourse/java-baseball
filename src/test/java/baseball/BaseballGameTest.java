package baseball;

import baseball.domain.Computer;
import baseball.domain.GameResult;
import baseball.domain.Referee;
import baseball.domain.User;

import baseball.view.Message;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.*;

class BaseballGameTest {

    @Test
    void 게임을_실행하면_컴퓨터_사용자_심판_객체들이_생성된다() {
        // given
        BaseballGame baseballGame;

        // when
        baseballGame = new BaseballGame();
        Computer computer = baseballGame.getComputer();
        User user = baseballGame.getUser();
        Referee referee = baseballGame.getReferee();

        // then
        assertThat(computer).isNotNull();
        assertThat(user).isNotNull();
        assertThat(referee).isNotNull();
    }


    @Test
    void 게임이_시작되면_컴퓨터는_정답을_생성한다() {
        // given
        BaseballGame baseballGame = new BaseballGame();
        Computer computer = baseballGame.getComputer();

        // when
        computer.generateAnswer();
        String answer = computer.getAnswer();

        // then
        assertThat(answer).isNotNull();
        assertThat(answer).isNotBlank();
        assertThat(answer).isNotEmpty();
    }

    @Test
    void 게임이_시작되면_컴퓨터가_생성한_정답은_길이가_3이다() {
        // given
        BaseballGame baseballGame = new BaseballGame();
        Computer computer = baseballGame.getComputer();

        // when
        computer.generateAnswer();

        // then
        assertThat(computer.getAnswer().length()).isEqualTo(3);
    }

    @Test
    void 게임이_시작되면_사용자는_3자리_숫자를_입력한다() {
        // given
        BaseballGame baseballGame = new BaseballGame();
        User user = baseballGame.getUser();
        String userNumber = "123";
        String expectedNumber = "123";

        // when
        InputStream in = new ByteArrayInputStream(userNumber.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        user.enterNumber();

        // then
        assertThat(user.getInputNumber()).isEqualTo(expectedNumber);
    }

    @Test
    void 사용자_입력이_정답과_같으면_해당게임_종료_조건이_만족된다() {
        // given
        BaseballGame baseballGame = new BaseballGame();
        Computer computer = baseballGame.getComputer();

        Referee referee = baseballGame.getReferee();
        boolean expectedExitFlag = true;

        // when
        computer.generateAnswer();
        String userNumber = computer.getAnswer();
        GameResult result = referee.judge(computer.getAnswer(), userNumber);

        // then
        assertThat(!baseballGame.isGameContinue(result.getStrikeCount())).isEqualTo(expectedExitFlag);
    }

    @Test
    void 해당_게임이_종료되면_게임종료_메시지가_출력된다() {
        // given
        BaseballGame baseballGame = new BaseballGame();
        Computer computer = baseballGame.getComputer();
        Referee referee = baseballGame.getReferee();
        String expectedMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";

        // when
        computer.generateAnswer();
        String userNumber = computer.getAnswer();
        GameResult result = referee.judge(computer.getAnswer(), userNumber);

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        if (!baseballGame.isGameContinue(result.getStrikeCount())) {
            Message.showGameEndMessage();
        }

        // then
        assertThat(out.toString()).isEqualTo(expectedMessage);
    }

    @Test
    void 해당_게임이_종료되면_재시작_여부를_묻는_메시지가_출력된다() {
        // given
        BaseballGame baseballGame = new BaseballGame();
        Computer computer = baseballGame.getComputer();
        Referee referee = baseballGame.getReferee();
        String expectedMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";

        // when
        computer.generateAnswer();
        String userNumber = computer.getAnswer();
        GameResult result = referee.judge(computer.getAnswer(), userNumber);

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        if (!baseballGame.isGameContinue(result.getStrikeCount())) {
            Message.showRetryRequestMessage();
        }

        // then
        assertThat(out.toString()).isEqualTo(expectedMessage);
    }
}
