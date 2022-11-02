package baseball.model;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BaseBallResultTypeTest {

    @Test
    void findBallResultType() {

            String homeRun = "123";
            String input = "321";
            int index = 1;
        BaseBallResultType ballResultType = BaseBallResultType.findBallResultType(homeRun, input, index);
        assertThat(ballResultType).isEqualTo(BaseBallResultType.STRIKE);
    }
}