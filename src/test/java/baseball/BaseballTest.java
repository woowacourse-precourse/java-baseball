package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import static baseball.Application.*;


class BaseballTest {
    @Test
    void getGuideMessage_현재_userNumber_상태에_따른_메시지_반환() {
        String input = "123";
        String result = getGuideMessage(input);
        assertThat(result).isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
    @Test
    void getGuideMessage_현재_userNumber_상태에_따른_메시지_반환2() {
        String input = null;
        String result = getGuideMessage(input);
        assertThat(result).isEqualTo("숫자 야구 게임을 시작합니다.");
    }
}