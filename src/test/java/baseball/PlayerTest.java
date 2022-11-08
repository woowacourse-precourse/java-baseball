package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    Player player;

    @BeforeEach
    void beforeEach() {
        player = new Player();
    }

    @Test
    void enterNumber_메서드로_서로다른_3자리숫자_입력한_경우_정상리턴() {
        // given
        String playerInput = "123";
        List<Integer> expectedList = Arrays.stream(playerInput.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        // when
        command(playerInput);
        List<Integer> integerList = player.enterNumber();
        // then
        assertThat(integerList).isEqualTo(expectedList);
    }

    @Test
    void enterNumber_메서드로_숫자가_아닌값을_입력한경우_예외발생() {
        // given
        String playerInput = "가나다";
        // when, then
        command(playerInput);
        assertThatThrownBy(player::enterNumber).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void enterNumber_메서드로_중복된_숫자를_입력한경우_예외발생() {
        // given
        String playerInput = "112";
        // when, then
        command(playerInput);
        assertThatThrownBy(player::enterNumber).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void enterRestartNumber_메서드로_1을_입력한경우_정상리턴() {
        // given
        String playerInput = "1";
        // when
        command(playerInput);
        int inputNumber = player.enterRestartNumber();
        // then
        assertThat(inputNumber).isEqualTo(Integer.parseInt(playerInput));
    }

    @Test
    void enterRestartNumber_메서드로_2을_입력한경우_정상리턴() {
        // given
        String playerInput = "2";
        // when
        command(playerInput);
        int inputNumber = player.enterRestartNumber();
        // then
        assertThat(inputNumber).isEqualTo(Integer.parseInt(playerInput));
    }


    @Test
    void enterRestartNumber_메서드로_1과_2가_아닌값을_입력한_경우_예외발생() throws Exception {
        // given
        String playerInput = "3";
        // when, then
        command(playerInput);
        assertThatThrownBy(player::enterRestartNumber).isInstanceOf(IllegalArgumentException.class);
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

}