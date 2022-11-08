package baseball.domain.manager;

import baseball.constant.GameStatus;
import baseball.util.BallCount;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class NumberBaseBallManagerTest {

    NumberBaseBallManager baseballManager = spy(new NumberBaseBallManager());

    @DisplayName("IN_GAME status인 경우 검증할 때 verifyGuess Method 실행")
    @Test
    void givenInGameStatus_whenValidate_thenValidateGuess() {
        //given
        String str = "329";
        doCallRealMethod().when(baseballManager).validate(any(String.class));
        given(baseballManager.getStatus()).willReturn(GameStatus.IN_GAME);
        doNothing().when(baseballManager).validateGuess(any(String.class));
        //when
        baseballManager.validate(str);

        //then
        Mockito.verify(baseballManager).validateGuess(str);
    }

    @DisplayName("PENDING status인 경우 검증시 validateAnswerContinueOrNot Method 실행")
    @Test
    void givenPendingStatus_whenValidate_ValidateAnswerContinueOrNot() {
        //given
        String str = "329";
        doCallRealMethod().when(baseballManager).validate(any(String.class));
        given(baseballManager.getStatus()).willReturn(GameStatus.PENDING);
        doNothing().when(baseballManager).validateAnswerContinueOrNot(any(String.class));

        //when
        baseballManager.validate(str);

        //then
        Mockito.verify(baseballManager).validateAnswerContinueOrNot(str);
    }

    @DisplayName("게임 재시작 요청 시 숫자가 아닌 값을 입력하면 에러")
    @Test
    void givenNotDigit_whenValidateContinueOrNot_ThrowError() {
        //given
        String str = "d";
        doCallRealMethod().when(baseballManager).
                validateAnswerContinueOrNot(any(String.class));

        //when
        Throwable thrown = catchThrowable(()
                -> baseballManager.validateAnswerContinueOrNot(str));

        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임 재시작 요청 시 1,2 중 하나를 입력하면 아무것도 수행하지 않는다.")
    @Test
    void givenNotDigit_whenValidateContinueOrNot_thenDoNothing() {
        //given
        String str = "1";
        doCallRealMethod().when(baseballManager).
                validateAnswerContinueOrNot(any(String.class));

        //when
        baseballManager.validateAnswerContinueOrNot(str);
    }

    @DisplayName("게임 중 숫자가 아닌 것들을 입력하면 오류 반환")
    @Test
    void givenString_whenValidateGuess_thenReturnError() {
        //given
        String str = "daw";
        doCallRealMethod().when(baseballManager).
                validateGuess(any(String.class));

        //when
        Throwable thrown = catchThrowable(()
                -> baseballManager.validateGuess(str));

        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임 중 중복된 숫자를 입력하면 오류 반환")
    @Test
    void givenDuplicateDigit_whenValidateGuess_thenReturnError() {
        //given
        String str = "199";
        doCallRealMethod().when(baseballManager).
                validateGuess(any(String.class));

        //when
        Throwable thrown = catchThrowable(()
                -> baseballManager.validateGuess(str));

        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임 중 입력량이 부족하면 오류 반환")
    @Test
    void givenLackInput_whenValidateGuess_thenReturnError() {
        //given
        String str = "13";
        doCallRealMethod().when(baseballManager).
                validateGuess(any(String.class));

        //when
        Throwable thrown = catchThrowable(()
                -> baseballManager.validateGuess(str));

        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임 중 올바른 입력값이 들어오면 아무것도 하지 않는다")
    @Test
    void givenRightInput_whenValidateGuess_thenDoNothing() {
        //given
        String str = "134";
        doCallRealMethod().when(baseballManager).
                validateGuess(any(String.class));

        //when
        baseballManager.validateGuess(str);
    }

    @DisplayName("결과값이 3스트라이크이면 끝났다고 결정.")
    @Test
    void givenThreeStrike_whenCheckResult_DetermineGameIsSetOrNot() {
        //given
        BallCount result = new BallCount(3, 0);

        //when
        baseballManager.checkResult(result);

        //then
        assertThat(baseballManager.getStatus()).isEqualTo(GameStatus.PENDING);
    }

    @DisplayName("결과값이 3스트라이크가 아니면 끝나지 않았다고 결정.")
    @Test
    void givenBallCount_whenCheckResult_DetermineGameIsSetOrNot() {
        //given
        BallCount result = new BallCount(2, 1);

        //when
        baseballManager.checkResult(result);

        //then
        assertThat(baseballManager.getStatus()).isNotEqualTo(GameStatus.PENDING);
    }
}