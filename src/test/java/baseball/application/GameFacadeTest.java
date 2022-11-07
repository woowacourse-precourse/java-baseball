package baseball.application;

import baseball.domain.ball.Balls;
import baseball.domain.hint.Hint;
import baseball.factory.BallFactory;
import baseball.factory.InputFactory;
import baseball.global.config.AppConfig;
import baseball.global.utils.message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameFacadeTest {

    AppConfig appConfig = new AppConfig();
    GameFacade gameFacade = appConfig.gameFacade();

    @Test
    @DisplayName("컴퓨터가 랜덤으로 세자리 숫자 만들기")
    void createAnswerBalls() {
        //given
        final List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        //when
        final Balls answerBalls = gameFacade.createAnswerBalls();
        //then
        assertThat(answerBalls.getBalls().size()).isEqualTo(3);
        assertThat(answerBalls.getBallNumbers().stream().filter(integerList::contains).count()).isEqualTo(3L);
    }


    @Nested
    @DisplayName("사용자가 입력한 3자리 숫자로 Balls 일급 컬렉션 만들기")
    class createPlayerBalls {

        @Test
        @DisplayName("[성공]")
        void success() {
            //given
            InputFactory.inputNumber("123");
            final List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
            //when
            final Balls playerBalls = gameFacade.createPlayerBalls();
            //then
            assertThat(playerBalls.getBalls().size()).isEqualTo(3);
            assertThat(playerBalls.getBallNumbers().stream().filter(integerList::contains).count()).isEqualTo(3L);
        }

        @Test
        @DisplayName("입력받은 숫자가 3자리가 아니면 테스트 실패")
        void fail_1() {
            //given
            InputFactory.inputNumber("1234");
            //when && then
            assertThatThrownBy(gameFacade::createPlayerBalls)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.IS_NOT_THREE_DIGITS);
        }

        @Test
        @DisplayName("입력받은 숫자에 0이 포함되어 있으면 테스트 실패")
        void fail_2() {
            //given
            InputFactory.inputNumber("120");
            //when && then
            assertThatThrownBy(gameFacade::createPlayerBalls)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.IS_NOT_NUMBER_OR_CONTAIN_ZERO);
        }

        @Test
        @DisplayName("입력받은 숫자에 문자열 포함되어 있으면 테스트 실패")
        void fail_3() {
            //given
            InputFactory.inputNumber("abc");
            //when && then
            assertThatThrownBy(gameFacade::createPlayerBalls)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.IS_NOT_NUMBER_OR_CONTAIN_ZERO);
        }

        @Test
        @DisplayName("입력받은 숫자에 중복된 숫자가 있으면 테스트 실패")
        void fail_4() {
            //given
            InputFactory.inputNumber("112");
            //when && then
            assertThatThrownBy(gameFacade::createPlayerBalls)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.CONTAIN_DUPLICATE_NUMBER);
        }
    }

    @Nested
    @DisplayName("힌트 주기")
    class giveHint {

        @Test
        @DisplayName("컴퓨터가 입력한 3자리 숫자와 사용자가 입력한 3숫자가 위치와 값이 모두 같으면 3스트라이크")
        void three_strike() {
            //given
            final Balls answerBall = BallFactory.balls(List.of(1, 2, 3));
            final Balls playerBall = BallFactory.balls(List.of(1, 2, 3));
            //when
            final Hint hint = gameFacade.giveHint(playerBall, answerBall);
            //then
            assertThat(hint.getStrike()).isEqualTo(3);
            assertThat(hint.getBall()).isEqualTo(0);
        }

        @Test
        @DisplayName("컴퓨터가 입력한 3자리 숫자와 사용자가 입력한 3숫자가 값은 같지만 위치가 서로 다르면 3볼")
        void three_ball() {
            //given
            final Balls answerBall = BallFactory.balls(List.of(1, 2, 3));
            final Balls playerBall = BallFactory.balls(List.of(3, 1, 2));
            //when
            final Hint hint = gameFacade.giveHint(playerBall, answerBall);
            //then
            assertThat(hint.getStrike()).isEqualTo(0);
            assertThat(hint.getBall()).isEqualTo(3);
        }

        @Test
        @DisplayName("컴퓨터가 입력한 3자리 숫자와 사용자가 입력한 3숫자가 값과 위치가 모두 다르면 낫싱")
        void nothing() {
            //given
            final Balls answerBall = BallFactory.balls(List.of(1, 2, 3));
            final Balls playerBall = BallFactory.balls(List.of(4, 5, 6));
            //when
            final Hint hint = gameFacade.giveHint(playerBall, answerBall);
            //then
            assertThat(hint.getStrike()).isEqualTo(0);
            assertThat(hint.getBall()).isEqualTo(0);
        }

        @Test
        @DisplayName("같은거 1개, 위치 다른거 2개 = 2볼1스트라이크")
        void one_strike_two_ball() {
            //given
            final Balls answerBall = BallFactory.balls(List.of(1, 2, 3));
            final Balls playerBall = BallFactory.balls(List.of(1, 3, 2));
            //when
            final Hint hint = gameFacade.giveHint(playerBall, answerBall);
            //then
            assertThat(hint.getStrike()).isEqualTo(1);
            assertThat(hint.getBall()).isEqualTo(2);
        }

        @Test
        @DisplayName("같은거 2개, 위치 다른거 0개 = 2스트라이크")
        void two_strike() {
            //given
            final Balls answerBall = BallFactory.balls(List.of(1, 2, 3));
            final Balls playerBall = BallFactory.balls(List.of(1, 2, 5));
            //when
            final Hint hint = gameFacade.giveHint(playerBall, answerBall);
            //then
            assertThat(hint.getStrike()).isEqualTo(2);
            assertThat(hint.getBall()).isEqualTo(0);
        }

        @Test
        @DisplayName("같은거 0개, 위치 다른거 2개 = 2볼")
        void two_ball() {
            //given
            final Balls answerBall = BallFactory.balls(List.of(1, 2, 3));
            final Balls playerBall = BallFactory.balls(List.of(2, 1, 6));
            //when
            final Hint hint = gameFacade.giveHint(playerBall, answerBall);
            //then
            assertThat(hint.getStrike()).isEqualTo(0);
            assertThat(hint.getBall()).isEqualTo(2);
        }
    }

    @Nested
    @DisplayName("정답인지 체크")
    class judgeIsAnswer {

        @Test
        @DisplayName("3스트라이크면 정답!!")
        void isAnswer() {
            //given
            final Hint hint = Hint.create(3, 0);
            //when
            final boolean isAnswer = gameFacade.judgeIsAnswer(hint);
            //then
            assertThat(isAnswer).isTrue();
        }

        @Test
        @DisplayName("3스트라이크가 아니면 정답아님!!")
        void isNotAnswer() {
            //given
            final Hint hint = Hint.create(2, 1);
            //when
            final boolean isAnswer = gameFacade.judgeIsAnswer(hint);
            //then
            assertThat(isAnswer).isFalse();
        }
    }

    @Nested
    @DisplayName("게임을 다시 시작할건지 체크")
    class gameEndOrStop {

        @Test
        @DisplayName("2번을 누르면 게임 종료 boolean 값은 false")
        void gameEnd() {
            //given
            InputFactory.inputNumber("2");
            //when
            final boolean isRestart = gameFacade.gameEndOrRestart();
            //then
            assertThat(isRestart).isFalse();
        }

        @Test
        @DisplayName("1번을 누르면 게임 재시작 boolean 값은 true")
        void gameRestart() {
            //given
            InputFactory.inputNumber("1");
            //when
            final boolean isRestart = gameFacade.gameEndOrRestart();
            //then
            assertThat(isRestart).isTrue();
        }

        @Test
        @DisplayName("1,2번이 아닌 다른 입력을 하면 예외 발생")
        void fail() {
            //given
            InputFactory.inputNumber("aa");
            //when && then
            assertThatThrownBy(gameFacade::gameEndOrRestart)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INCORRECT_RESPONSE);
        }

    }


}
