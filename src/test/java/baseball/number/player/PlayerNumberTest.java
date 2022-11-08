package baseball.number.player;

import baseball.number.player.PlayerNumber;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerNumberTest {

    PlayerNumber playerNumber = new PlayerNumber();

    @Test
    void 사용자는_세게의_숫자를_입력해야_한다() {
        List<Integer> expectNumber = List.of(2,3,4);
        String input = "234";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        List<Integer> actualNumber = playerNumber.playerNumberToList();

        assertThat(expectNumber).isEqualTo(actualNumber);
    }
}
