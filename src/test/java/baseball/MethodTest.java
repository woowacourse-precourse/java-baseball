package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
}
