package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MessageTest {
    @DisplayName("첫 게임 시작 메시지 테스트")
    @Test
    void firstGameStartMessageTest() {
        //given
        Message message = new Message();
        //when
        String startMessage = message.start();
        //then
        assertThat(startMessage).isEqualTo("숫자 야구 게임을 시작합니다.");
    }

    @DisplayName("숫자입력 요구 메시지 테스트")
    @Test
    void requestNumberInputMessageTest() {
        //given
        Message message = new Message();
        //when
        String startMessage = message.requestThreeNumbers();
        //given
        assertThat(startMessage).isEqualTo("숫자를 입력해주세요 : ");
    }

    @DisplayName("새 게임 여부 요구 메시지 테스트")
    @Test
    void requestNewGameInputMessageTest() {
        //given
        Message message = new Message();
        //when
        String startMessage = message.requestNewOrStop();
        //then
        assertThat(startMessage).isEqualTo("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    @DisplayName("정답 메시지 테스트 테스트")
    @Test
    void requestSuccessMessageTest() {
        //given
        Message message = new Message();
        //when
        String successMessage = message.success();
        //then
        assertThat(successMessage).isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    @DisplayName("볼과 스트라이크가 0일 때 결과 메시지 테스트")
    @Test
    void nothingResultTest() {
        //given
        Message message = new Message();
        List<Integer> resultNothing = List.of(0, 0);
        //when
        String resultMessage = message.result(resultNothing);
        //then
        assertThat(resultMessage).isEqualTo("낫싱");
    }

    @DisplayName("볼만 존재할 때 결과 메시지 테스트")
    @Test
    void onlyBallResultTest() {
        //given
        Message message = new Message();
        List<Integer> resultBall = List.of(2, 0);
        //when
        String resultMessage = message.result(resultBall);
        //then
        assertThat(resultMessage).isEqualTo(resultBall.get(0) + "볼");
    }

    @DisplayName("스트라이크만 존재할 때 결과 메시지 테스트")
    @Test
    void onlyStrikeResultTest() {
        //given
        Message message = new Message();
        List<Integer> resultStrike = List.of(0, 3);
        //when
        String resultMessage = message.result(resultStrike);
        //then
        assertThat(resultMessage).isEqualTo(resultStrike.get(1) + "스트라이크");
    }

    @DisplayName("볼과 스트라이크 모두 존재할 때 결과 메시지 테스트")
    @Test
    void ballAndStrikeResultTest() {
        //given
        Message message = new Message();
        List<Integer> resultBoth = List.of(2, 1);
        //when
        String resultMessage = message.result(resultBoth);
        //then
        assertThat(resultMessage).isEqualTo(resultBoth.get(0) + "볼 " + resultBoth.get(1) + "스트라이크");
    }
}