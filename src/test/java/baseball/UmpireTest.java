package baseball;

import constants.Text;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class UmpireTest {
    Umpire umpire = new Umpire();

    @Test
    void 낫싱_확인() {
        List<Integer> computerNumber = List.of(4, 9, 3);
        List<Integer> playerNumber = List.of(1, 2, 7);

        Map<Text, Integer> hintRecord = umpire.compareNumber(computerNumber, playerNumber);

        assertThat(hintRecord).isEqualTo(null);
    }

    @Test
    void 볼_카운트() {
        List<Integer> computerNumber = List.of(4, 9, 3);
        List<Integer> playerNumber = List.of(9, 4, 1);

        Map<Text, Integer> hintRecord = umpire.compareNumber(computerNumber, playerNumber);

        Map<Text, Integer> expected = Map.of(
                Text.BALL, 2
        );

        assertThat(hintRecord).contains(Map.entry(Text.BALL, expected.get(Text.BALL)));
    }

    @Test
    void 스트라이크_카운트() {
        List<Integer> computerNumber = List.of(4, 9, 3);
        List<Integer> playerNumber = List.of(8, 9, 3);

        Map<Text, Integer> hintRecord = umpire.compareNumber(computerNumber, playerNumber);

        Map<Text, Integer> expected = Map.of(
                Text.STRIKE, 2
        );

        assertThat(hintRecord).contains(Map.entry(Text.STRIKE, expected.get(Text.STRIKE)));
    }
}
