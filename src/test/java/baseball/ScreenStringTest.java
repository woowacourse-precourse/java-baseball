package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ScreenStringTest {

    @Test
    void checkCommonMessage(){
        assertThat(ScreenString.GAME_START.getCommonMessage()).isEqualTo("숫자 야구 게임을 시작합니다.");
        assertThat(ScreenString.GAME_END.getCommonMessage()).isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    @Test
    void checkBallAndStrikeMessage(){
        assertThat(ScreenString.ballAndStrikeMessage(1,1)).isEqualTo("1볼 1스트라이크");
        assertThat(ScreenString.ballAndStrikeMessage(0,0)).isEqualTo("낫싱");
        assertThat(ScreenString.ballAndStrikeMessage(1,0)).isEqualTo("1볼");
        assertThat(ScreenString.ballAndStrikeMessage(0,3)).isEqualTo("3스트라이크");
    }
}