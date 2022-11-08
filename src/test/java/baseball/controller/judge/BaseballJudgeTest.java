package baseball.controller.judge;

import baseball.domain.user.Opponent;
import baseball.domain.user.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballJudgeTest {
    final BaseballJudge judge = new BaseballJudge();
    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @DisplayName("힌트를 출력한다")
    @Nested
    class hint {
        @DisplayName("1볼 1스트라이크")
        @Test
        void ball1strike1() {
            judge.showHint(1, 1);

            //then
            assertThat(outputStreamCaptor.toString().trim()).isEqualTo("1볼 1스트라이크");
        }

        @DisplayName("2볼 1스트라이크")
        @Test
        void ball2strike1() {
            judge.showHint(1, 2);

            //then
            assertThat(outputStreamCaptor.toString().trim()).isEqualTo("2볼 1스트라이크");
        }

        @DisplayName("2볼")
        @Test
        void ball2() {
            judge.showHint(0, 2);

            //then
            assertThat(outputStreamCaptor.toString().trim()).isEqualTo("2볼");
        }

        @DisplayName("3스트라이크")
        @Test
        void strike3() {
            judge.showHint(3, 0);

            //then
            assertThat(outputStreamCaptor.toString().trim()).isEqualTo("3스트라이크");
        }

        @DisplayName("낫싱")
        @Test
        void nothing() {
            judge.showHint(0, 0);

            //then
            assertThat(outputStreamCaptor.toString().trim()).isEqualTo("낫싱");
        }
    }

    @DisplayName("볼이나 스트라이크를 출력한다.")
    @Nested
    class checkStrikeBall {
        @DisplayName("1스트라이크")
        @Test
        void strike1() {
            //given
            Player player = new Player();
            List<Integer> playerList = List.of(1, 2, 3);
            player.setNumberList(playerList);

            List<Integer> opponentList = List.of(1, 8, 9);
            Opponent opponent = new Opponent(opponentList);

            //when
            judge.judgement(player, opponent);

            //then
            assertThat(outputStreamCaptor.toString().trim()).isEqualTo("1스트라이크");
        }

        @DisplayName("2스트라이크")
        @Test
        void strike2() {
            //given
            Player player = new Player();
            List<Integer> playerList = List.of(4, 9, 6);
            player.setNumberList(playerList);

            List<Integer> opponentList = List.of(1, 9, 6);
            Opponent opponent = new Opponent(opponentList);

            //when
            judge.judgement(player, opponent);

            //then
            assertThat(outputStreamCaptor.toString().trim()).isEqualTo("2스트라이크");
        }

        @DisplayName("3스트라이크")
        @Test
        void strike3() {
            //given
            Player player = new Player();
            List<Integer> playerList = List.of(7, 4, 8);
            player.setNumberList(playerList);

            List<Integer> opponentList = List.of(7, 4, 8);
            Opponent opponent = new Opponent(opponentList);

            //when
            judge.judgement(player, opponent);

            //then
            assertThat(outputStreamCaptor.toString().trim()).isEqualTo("3스트라이크");
        }

        @DisplayName("1볼")
        @Test
        void ball1() {
            //given
            Player player = new Player();
            List<Integer> playerList = List.of(7, 4, 8);
            player.setNumberList(playerList);

            List<Integer> opponentList = List.of(1, 7, 3);
            Opponent opponent = new Opponent(opponentList);

            //when
            judge.judgement(player, opponent);

            //then
            assertThat(outputStreamCaptor.toString().trim()).isEqualTo("1볼");
        }

        @DisplayName("2볼")
        @Test
        void ball2() {
            //given
            Player player = new Player();
            List<Integer> playerList = List.of(7, 4, 8);
            player.setNumberList(playerList);

            List<Integer> opponentList = List.of(8, 1, 4);
            Opponent opponent = new Opponent(opponentList);

            //when
            judge.judgement(player, opponent);

            //then
            assertThat(outputStreamCaptor.toString().trim()).isEqualTo("2볼");
        }

        @DisplayName("3볼")
        @Test
        void ball3() {
            //given
            Player player = new Player();
            List<Integer> playerList = List.of(5, 4, 3);
            player.setNumberList(playerList);

            List<Integer> opponentList = List.of(3, 5, 4);
            Opponent opponent = new Opponent(opponentList);

            //when
            judge.judgement(player, opponent);

            //then
            assertThat(outputStreamCaptor.toString().trim()).isEqualTo("3볼");
        }

        @DisplayName("1볼 1스트라이크")
        @Test
        void ball1strike1() {
            //given
            Player player = new Player();
            List<Integer> playerList = List.of(5, 4, 3);
            player.setNumberList(playerList);

            List<Integer> opponentList = List.of(5, 1, 4);
            Opponent opponent = new Opponent(opponentList);

            //when
            judge.judgement(player, opponent);

            //then
            assertThat(outputStreamCaptor.toString().trim()).isEqualTo("1볼 1스트라이크");
        }

        @DisplayName("2볼 1스트라이크")
        @Test
        void ball11strike2() {
            //given
            Player player = new Player();
            List<Integer> playerList = List.of(6, 5, 8);
            player.setNumberList(playerList);

            List<Integer> opponentList = List.of(8, 5, 6);
            Opponent opponent = new Opponent(opponentList);

            //when
            judge.judgement(player, opponent);

            //then
            assertThat(outputStreamCaptor.toString().trim()).isEqualTo("2볼 1스트라이크");
        }

        @DisplayName("낫싱")
        @Test
        void nothing() {
            //given
            Player player = new Player();
            List<Integer> playerList = List.of(6, 5, 8);
            player.setNumberList(playerList);

            List<Integer> opponentList = List.of(1, 2, 9);
            Opponent opponent = new Opponent(opponentList);

            //when
            judge.judgement(player, opponent);

            //then
            assertThat(outputStreamCaptor.toString().trim()).isEqualTo("낫싱");
        }
    }

    @DisplayName("정답일경우 true, 오답일경우 false 를 반환한다.")
    @Nested
    class judgement {
        @DisplayName("정답일 경우 '3스트라이크'를 출력하고 'true' 를 반환한다")
        @Test
        void returnTrue() {
            //given
            Player player = new Player();
            List<Integer> playerList = List.of(6, 5, 8);
            player.setNumberList(playerList);

            List<Integer> opponentList = List.of(6, 5, 8);
            Opponent opponent = new Opponent(opponentList);

            //when
            boolean judgement = judge.judgement(player, opponent);

            //then
            assertThat(judgement).isTrue();
            assertThat(outputStreamCaptor.toString().trim()).isEqualTo("3스트라이크");
        }

        @DisplayName("오답일경우 힌트를 출력하고 'false' 를 반환한다")
        @Test
        void returnFalse() {
            //given
            Player player = new Player();
            List<Integer> playerList = List.of(6, 5, 8);
            player.setNumberList(playerList);

            List<Integer> opponentList = List.of(6, 1, 8);
            Opponent opponent = new Opponent(opponentList);

            //when
            boolean judgement = judge.judgement(player, opponent);

            //then
            assertThat(judgement).isFalse();
            assertThat(outputStreamCaptor.toString().trim()).isEqualTo("2스트라이크");
        }
    }
}