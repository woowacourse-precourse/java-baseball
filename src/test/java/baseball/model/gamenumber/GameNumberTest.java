package baseball.model.gamenumber;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class GameNumberTest {
    GameNumber gameNumber;

    @AfterEach
    public void afterEach() {
        gameNumber.clear();
    }

    @Test
    void 문자열_리스트로_저장() {
        // given
        gameNumber = new GameNumber(new ArrayList<Integer>(List.of(1, 2, 3)));

        // when
        GameNumber gameNumberString = new GameNumber("123");

        // then
        assertThat(gameNumberString.getNumberList()).isEqualTo(gameNumber.getNumberList());
    }
}