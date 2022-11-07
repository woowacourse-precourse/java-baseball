package baseball.player;
import baseball.exception.InputException;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {
    @Test
    @DisplayName("check opponent makes 3 digit integer properly")
    public void initialize_computer_Test() {
        Player player = new Player();
        assertThat(player.initializeOpponent()).doesNotHaveDuplicates();
    }

}
