package baseball;

import baseball.service.BaseBallService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseBallTest {

    private BaseBallService baseBallService = new BaseBallService();

    @Test
    @DisplayName("숫자 야구 게임 테스트")
    public void getResultGame() {
        baseBallService.initGame();
        baseBallService.userInputSave("123");

        baseBallService.setComputerNumberList(List.of(1,4,2));
        baseBallService.checkResult();

        assertThat(baseBallService.getStrike()).isEqualTo(1);
        assertThat(baseBallService.getBall()).isEqualTo(1);
    }
}
