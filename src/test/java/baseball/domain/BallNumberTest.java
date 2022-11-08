package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class BallNumberTest {
    @Test
    public void fromIntegerListSuccessTest() throws Exception {
        // given
        List<Integer> ballNumberList = List.of(2, 6, 3);

        // when
        BallNumber ballNumber = BallNumber.fromIntegerList(ballNumberList);

        // then
        for (int i = 0; i < 3; ++i) {
            assertThat(ballNumber.get(i)).isEqualTo(ballNumberList.get(i));
        }
    }
}
