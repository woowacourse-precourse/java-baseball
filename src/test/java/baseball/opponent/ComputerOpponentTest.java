package baseball.opponent;

import baseball.core.ComputerOpponent;
import baseball.core.BallStrike;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerOpponentTest {

    ComputerOpponent opponent;

    @Nested
    @DisplayName("answer 테스트")
    class AnswerTest {

        @Test
        @DisplayName("컴퓨터 숫자 123, 입력 숫자 456 -> 0볼 0스트라이크")
        void case1() {
            //given
            List<Integer> opponentRandomNum = List.of(1, 2, 3);
            List<Integer> numList = List.of(4, 5, 6);
            opponent = new ComputerOpponent(opponentRandomNum);
            BallStrike expected = new BallStrike(0, 0);

            //when
            BallStrike res = opponent.answer(numList);

            //then
            assertThat(expected.getBallCount()).isEqualTo(expected.getBallCount());
            assertThat(expected.getStrikeCount()).isEqualTo(expected.getStrikeCount());
        }

        @Test
        @DisplayName("컴퓨터 숫자 123, 입력 숫자 345 -> 1볼 0스트라이크")
        void case2() {
            //given
            List<Integer> opponentRandomNum = List.of(1, 2, 3);
            List<Integer> numList = List.of(3, 4, 5);
            opponent = new ComputerOpponent(opponentRandomNum);
            BallStrike expected = new BallStrike(1, 0);

            //when
            BallStrike res = opponent.answer(numList);

            //then
            assertThat(expected.getBallCount()).isEqualTo(expected.getBallCount());
            assertThat(expected.getStrikeCount()).isEqualTo(expected.getStrikeCount());
        }

        @Test
        @DisplayName("컴퓨터 숫자 123, 입력 숫자 189 -> 0볼 1스트라이크")
        void case3() {
            //given
            List<Integer> opponentRandomNum = List.of(1, 2, 3);
            List<Integer> numList = List.of(1, 8, 9);
            opponent = new ComputerOpponent(opponentRandomNum);
            BallStrike expected = new BallStrike(0, 1);

            //when
            BallStrike res = opponent.answer(numList);

            //then
            assertThat(expected.getBallCount()).isEqualTo(expected.getBallCount());
            assertThat(expected.getStrikeCount()).isEqualTo(expected.getStrikeCount());
        }

        @Test
        @DisplayName("컴퓨터 숫자 123, 입력 숫자 135 -> 1볼 1스트라이크")
        void case4() {
            //given
            List<Integer> opponentRandomNum = List.of(1, 2, 3);
            List<Integer> numList = List.of(1, 3, 5);
            opponent = new ComputerOpponent(opponentRandomNum);
            BallStrike expected = new BallStrike(1, 1);

            //when
            BallStrike res = opponent.answer(numList);

            //then
            assertThat(expected.getBallCount()).isEqualTo(expected.getBallCount());
            assertThat(expected.getStrikeCount()).isEqualTo(expected.getStrikeCount());
        }

        @Test
        @DisplayName("컴퓨터 숫자 123, 입력 숫자 132 -> 2볼 1스트라이크")
        void case5() {
            //given
            List<Integer> opponentRandomNum = List.of(1, 2, 3);
            List<Integer> numList = List.of(1, 3, 2);
            opponent = new ComputerOpponent(opponentRandomNum);
            BallStrike expected = new BallStrike(2, 1);

            //when
            BallStrike res = opponent.answer(numList);

            //then
            assertThat(expected.getBallCount()).isEqualTo(expected.getBallCount());
            assertThat(expected.getStrikeCount()).isEqualTo(expected.getStrikeCount());
        }

        @Test
        @DisplayName("컴퓨터 숫자 123, 입력 숫자 123 -> 0볼 3스트라이크")
        void case6() {
            //given
            List<Integer> opponentRandomNum = List.of(1, 2, 3);
            List<Integer> numList = List.of(1, 2, 3);
            opponent = new ComputerOpponent(opponentRandomNum);
            BallStrike expected = new BallStrike(0, 3);

            //when
            BallStrike res = opponent.answer(numList);

            //then
            assertThat(expected.getBallCount()).isEqualTo(expected.getBallCount());
            assertThat(expected.getStrikeCount()).isEqualTo(expected.getStrikeCount());
        }
    }

}