package baseball.model;

import baseball.RandomUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
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

    @Test
    void 상대방_생성과_동시에_초기화되는_스트라이크_볼_카운트_맵의_Size는_2() {
        OpponentComputer opponentComputer = new OpponentComputer(123);
        int strikeAndBallCountMapSize = opponentComputer.getStrikeAndBallCountMap().size();

        assertThat(strikeAndBallCountMapSize).isEqualTo(2);
    }

    @Test
    void 각_자리의_수를_리스트에_저장() {
        OpponentComputer opponentComputer = new OpponentComputer(123);
        List<String> numberEachDigits = opponentComputer.addEachDigitToList(123);

        assertThat(numberEachDigits.size()).isEqualTo(3);
        assertThat(numberEachDigits.get(0)).isEqualTo("1");
        assertThat(numberEachDigits.get(1)).isEqualTo("2");
        assertThat(numberEachDigits.get(2)).isEqualTo("3");
    }

    @Test
    void 상대방_수_리스트와_플레이어_수_리스트를_비교해서_스트라이크_볼_개수_판정_낫싱() {
        OpponentComputer opponentComputer = new OpponentComputer(123);
        List<String> opponentComputerNumberEachDigits = List.of("123");
        List<String> playerNumberEachDigits = List.of("456");
        opponentComputer.judgeStrikeOrBall(opponentComputerNumberEachDigits, playerNumberEachDigits);

        assertThat(opponentComputer.getStrikeAndBallCountMap().get("Strike")).isEqualTo(0);
        assertThat(opponentComputer.getStrikeAndBallCountMap().get("Ball")).isEqualTo(0);
    }
}
