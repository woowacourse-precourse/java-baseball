package baseball.test.domainTest;

import baseball.domain.Again;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AgainTest {
    @Test
    void getDoTryTest() {
        Again again = new Again(1);
        int target = 1;
        assertThat(again.getDoTry()).isEqualTo(target);
    }

}
