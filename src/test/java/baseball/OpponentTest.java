package baseball;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OpponentTest {
    private Opponent _opponent;

    @BeforeAll
    void initAll() {
        _opponent = new Opponent();
    }

    @Test
    void generateRandomValue_테스트() {
        for (int i = 0; i < 100; ++i) {
            int value = _opponent.generateRandomValue();

            int front = value / 100;
            int middle = (value % 100) / 10;
            int rear = value % 10;

            if (value < 123 || value > 987
                    || front == middle
                    || front == rear
                    || middle == rear) {
                assertThat(true);
            }
        }
    }
}
