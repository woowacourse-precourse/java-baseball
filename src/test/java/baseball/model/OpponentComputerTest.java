package baseball.model;

import baseball.RandomUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class OpponentComputerTest {

    @Test
    void 상대방_생성과_동시에_랜덤_수_저장() {
        OpponentComputer opponentComputer = new OpponentComputer(RandomUtil.createRandomNumber());
        int opponentComputerNumber = opponentComputer.getNumber();

        assertThat(opponentComputerNumber).isNotNull();
    }

    @Test
    void 상대방_생성과_동시에_초기화되는_스트라이크_볼_카운트_맵의_Key는_Strike_Or_Ball() {
        OpponentComputer opponentComputer = new OpponentComputer(123);
        Map<String, Integer> strikeAndBallCountMap = opponentComputer.getStrikeAndBallCountMap();

        assertThat(strikeAndBallCountMap.containsKey("Strike")).isTrue();
        assertThat(strikeAndBallCountMap.containsKey("Ball")).isTrue();
    }

    @Test
    void 상대방_생성과_동시에_초기화되는_스트라이크_볼_카운트_맵의_Value는_0() {
        OpponentComputer opponentComputer = new OpponentComputer(123);
        Integer strikeCount = opponentComputer.getStrikeAndBallCountMap().get("Strike");
        Integer ballCount = opponentComputer.getStrikeAndBallCountMap().get("Ball");

        assertThat(strikeCount).isEqualTo(0);
        assertThat(ballCount).isEqualTo(0);
    }
}
