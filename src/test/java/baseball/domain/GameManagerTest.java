package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.domain.GameManager.ExecuteStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameManagerTest {

    @DisplayName("존재하는 실행상태는 알맞은 실행상태를 생성한다.")
    @Test
    void generateExecuteStatus() {
        //given
        String status = ExecuteStatus.RESTART.getStatus();

        //when
        ExecuteStatus result = ExecuteStatus.from(status);

        //then
        assertThat(result).isEqualTo(ExecuteStatus.RESTART);
    }

    @DisplayName("존재하지 않는 실행상태는 IllegalArgumentException 반환한다.")
    @Test
    void generateExecuteStatusFail() {
        //given
        String status = "@!";

        //then
        assertThatThrownBy(() -> ExecuteStatus.from(status))
            .isInstanceOf(IllegalArgumentException.class);
    }

}