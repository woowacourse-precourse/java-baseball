package baseball;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TurnTest {
    @Test
    void getPlayerInput_test_getting_input() {
        Turn turn = new Turn();
        final byte[] buf = String.join("\n", "234").getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        String result = "234";

        assertThat(turn.getPlayerInput()).isEqualTo(result);
    }
}
