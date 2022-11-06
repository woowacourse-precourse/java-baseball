package baseball;

import baseball.BaseBallGame;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseBallGameTest {
    @Test
    void DTO를_입력받아_결과값을_출력() {
        //given
        GameController gc = new GameController();
        BaseballGameResultDto testDto = new BaseballGameResultDto(1,2,false);

        //when
        String result = gc.printResult(testDto);

        //then
        assertThat(result).isEqualTo("2볼 1스트라이크 ");
    }
}
