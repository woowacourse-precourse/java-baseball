package baseball;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameMachineTest {
    GameMachine gameMachine = new GameMachine();

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

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

    @Test
    void gamer에게_입력받은_문자열을_integer_list_로_반환한다() {
        // Given
        Gamer gamer = new Gamer();
        String input = "123";
        command(input);

        // When
        List<Integer> threeDiffDigit = gameMachine.askInputThreeDiffDigit(gamer);

        // Then
        List<Integer> integerList = List.of(1, 2, 3);
        assertThat(threeDiffDigit).isEqualTo(integerList);
    }

}
