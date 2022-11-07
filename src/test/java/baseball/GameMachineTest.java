package baseball;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameMachineTest {
    GameMachine gameMachine = new GameMachine();

    @Test
    void 중복되는_숫자가_없는_길이가_3인_integer_list_생성한다() {
        // When
        List<Integer> integerList = gameMachine.generateThreeDiffDigit();

        int size = integerList.size();
        long distinctIntegerListSize = integerList.stream().distinct().count();

        // Then
        assertThat(size).isEqualTo(3);
        assertThat(distinctIntegerListSize).isEqualTo(3);
    }

}
