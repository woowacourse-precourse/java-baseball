package baseball.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.fail;

public class NumberBaseballGameServiceTest {

    @Test
    void 상대방_컴퓨터_생성() {
        NumberBaseballGameService numberBaseballGameService = new NumberBaseballGameService();
        numberBaseballGameService.generateOpponentComputer();
        if (numberBaseballGameService.getOpponentComputer() == null) {
            fail();
        }
    }

    @Test
    void 사용자_수를_받아서_스트라이크_볼을_판정() {
        NumberBaseballGameService numberBaseballGameService = new NumberBaseballGameService();
        numberBaseballGameService.generateOpponentComputer();
        int opponentComputerNumber = numberBaseballGameService.getOpponentComputer().getNumber();
        Map<String, Integer> strikeOrBallCountMap =
                numberBaseballGameService.judgeStrikeOrBallCount(String.valueOf(opponentComputerNumber));
        Integer strikeCount = strikeOrBallCountMap.get("Strike");

        Assertions.assertThat(strikeCount).isEqualTo(3);
    }
}
