package baseball.domain;

import baseball.domain.game.service.GameService;
import baseball.domain.hint.Hint;
import baseball.factory.InputFactory;
import baseball.global.config.AppConfig;
import baseball.global.utils.message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameServiceTest {

    AppConfig appConfig = new AppConfig();
    GameService gameService = appConfig.gameService();

    @Test
    @DisplayName("사용자에게 3자리 숫자 입력받기")
    void requestInputNumber() {
        //given
        InputFactory.inputNumber("123");
        //when
        final String number = gameService.requestInputNumber();
        //then
        assertThat(number).isEqualTo("123");
    }

    @Nested
    @DisplayName("3자리 숫자 검증하기")
    class validateNumber {

        @Test
        @DisplayName("중복없이 1~9자리 3자리 숫자를 입력받았으면 성공")
        void success() {
            //when && then
            gameService.validateNumber("123");
        }

        @Test
        @DisplayName("입력받은 숫자가 3자리가 아니면 테스트 실패")
        void fail_1() {
            //when && then
            assertThatThrownBy(() -> gameService.validateNumber("1234"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.IS_NOT_THREE_DIGITS);
        }

        @Test
        @DisplayName("입력받은 숫자에 0이 포함되어 있으면 테스트 실패")
        void fail_2() {
            //when && then
            assertThatThrownBy(() -> gameService.validateNumber("120"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.IS_NOT_NUMBER_OR_CONTAIN_ZERO);
        }

        @Test
        @DisplayName("입력받은 숫자에 문자열 포함되어 있으면 테스트 실패")
        void fail_3() {
            //when && then
            assertThatThrownBy(() -> gameService.validateNumber("abc"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.IS_NOT_NUMBER_OR_CONTAIN_ZERO);
        }

        @Test
        @DisplayName("입력받은 숫자에 중복된 숫자가 있으면 테스트 실패")
        void fail_4() {
            //when && then
            assertThatThrownBy(() -> gameService.validateNumber("122"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.CONTAIN_DUPLICATE_NUMBER);
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
            final boolean isAnswer = gameService.judgeIsAnswer(hint);
            //then
            assertThat(isAnswer).isTrue();
        }

        @Test
        @DisplayName("3스트라이크가 아니면 정답아님!!")
        void isNotAnswer() {
            //given
            final Hint hint = Hint.create(2, 1);
            //when
            final boolean isAnswer = gameService.judgeIsAnswer(hint);
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
            final boolean isRestart = gameService.endOrRestart();
            //then
            assertThat(isRestart).isFalse();
        }

        @Test
        @DisplayName("1번을 누르면 게임 재시작 boolean 값은 true")
        void gameRestart() {
            //given
            InputFactory.inputNumber("1");
            //when
            final boolean isRestart = gameService.endOrRestart();
            //then
            assertThat(isRestart).isTrue();
        }

        @Test
        @DisplayName("1,2번이 아닌 다른 입력을 하면 예외 발생")
        void fail() {
            //given
            InputFactory.inputNumber("aa");
            //when && then
            assertThatThrownBy(gameService::endOrRestart)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INCORRECT_RESPONSE);
        }

    }
}
