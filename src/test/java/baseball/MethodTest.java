package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MethodTest {
    private final GameMachine gameMachine;

    MethodTest() {
        gameMachine = new GameMachine();
    }

    @Test
    void convertGamerNumberTest() {
        assertThatThrownBy(() -> gameMachine.convertGamerNumber("1234"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> gameMachine.convertGamerNumber("051"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> gameMachine.convertGamerNumber("test"))
                .isInstanceOf(IllegalArgumentException.class);

        List<Integer> result = Stream.of(1, 2, 3).collect(Collectors.toList());

        assertThat(result).isEqualTo(gameMachine.convertGamerNumber("123"));
    }

    @Test
    void restartTest() {
        assertThatThrownBy(() -> gameMachine.restart("1234"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> gameMachine.restart("3"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThat(true).isEqualTo(gameMachine.restart("1"));

        assertThat(false).isEqualTo(gameMachine.restart("2"));
    }

    @Test
    void strikeAndBallTest() {
        gameMachine.computer = Arrays.asList(7, 1, 3);

        gameMachine.gamer = Arrays.asList(1, 2, 3);
        List<Integer> result = Arrays.asList(1, 1);
        assertThat(result).isEqualTo(gameMachine.strikeAndBall());

        gameMachine.gamer = Arrays.asList(1, 4, 5);
        result = Arrays.asList(0, 1);
        assertThat(result).isEqualTo(gameMachine.strikeAndBall());

        gameMachine.gamer = Arrays.asList(6, 7, 1);
        result = Arrays.asList(0, 2);
        assertThat(result).isEqualTo(gameMachine.strikeAndBall());

        gameMachine.gamer = Arrays.asList(2, 1, 6);
        result = Arrays.asList(1, 0);
        assertThat(result).isEqualTo(gameMachine.strikeAndBall());

        gameMachine.gamer = Arrays.asList(7, 1, 3);
        result = Arrays.asList(3, 0);
        assertThat(result).isEqualTo(gameMachine.strikeAndBall());
    }
}
