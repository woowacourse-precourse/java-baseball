package baseball.model;

import org.junit.jupiter.api.Test;

import static baseball.service.UserNumValidatorService.isThreelen;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class HintReqTest {

    @Test
    void getBallCount() {
        HintReq hintReq = new HintReq(1,2);
        assertThat(1).isEqualTo(hintReq.getBallCount());
    }

    @Test
    void getStrikeCount() {
        HintReq hintReq = new HintReq(1,2);
        assertThat(2).isEqualTo(hintReq.getStrikeCount());
    }
}