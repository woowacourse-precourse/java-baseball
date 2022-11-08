package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;


class HitterTest {

    private final Hitter hitter = new Hitter();

    @Test
    void generateNumber_서로다른_숫자3개_리턴() {
        assertThat(hitter.getNumber()).hasSize(3);
    }


}