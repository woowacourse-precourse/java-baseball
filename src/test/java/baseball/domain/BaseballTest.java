package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class BaseballTest {

    @Test
    void 값을_반환한다() {
        Baseball baseball = new Baseball(1);

        assertThat(baseball.getNumber()).isEqualTo(1);
    }

}
