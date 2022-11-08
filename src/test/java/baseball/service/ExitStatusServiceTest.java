package baseball.service;

import org.junit.jupiter.api.Test;

import static baseball.service.ExitStatusService.exit;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ExitStatusServiceTest {

    @Test
    void 게임_반복_여부(){
        assertThat(false).isEqualTo(exit("1"));
        assertThat(true).isEqualTo(exit("2"));
        assertSimpleTest(() ->
                assertThatThrownBy(() -> UserNumValidatorService.validator("1hi4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

    }
}