package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;

class GameResultTest {

    @Test
    void 게임_결과_출력_메시지_테스트() {
        //given
        GameResult 쓰리_스트라이크_게임 = new GameResult(3, 0);
        GameResult 원_스트라이크_원_볼_게임 = new GameResult(1, 1);
        GameResult 낫싱_게임 = new GameResult(0, 0);

        //when
        쓰리_스트라이크_게임.makePrintMessageByGameResult();
        원_스트라이크_원_볼_게임.makePrintMessageByGameResult();
        낫싱_게임.makePrintMessageByGameResult();

        //then
        assertAll(
                () -> Assertions.assertThat(쓰리_스트라이크_게임.getGameResultMessage()).isEqualTo("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
                () -> Assertions.assertThat(원_스트라이크_원_볼_게임.getGameResultMessage()).isEqualTo("1볼 1스트라이크"),
                () -> Assertions.assertThat(낫싱_게임.getGameResultMessage()).isEqualTo("낫싱")
        );
    }

    @Test
    void 게임_종료() {
        //given
        GameResult 쓰리_스트라이크_게임 = new GameResult(3, 0);

        //when
        boolean 게임종료 = 쓰리_스트라이크_게임.stop();

        //then
        Assertions.assertThat(게임종료).isTrue();
    }
}
