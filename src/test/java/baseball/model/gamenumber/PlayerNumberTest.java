package baseball.model.gamenumber;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerNumberTest {
    PlayerNumber playerNumber;

    @BeforeEach
    void beforeEach() {
        playerNumber = new PlayerNumber();
    }

    @AfterEach
    void afterEach() {
        playerNumber.clear();
    }

    @Test
    void 생성자_확인() {
        // given
        playerNumber = new PlayerNumber("123");

        // when
        List<Integer> list = playerNumber.getNumberList();

        // then
        assertThat(list).isEqualTo(new ArrayList<Integer>(List.of(1, 2, 3)));
    }
}