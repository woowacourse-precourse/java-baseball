import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.Test;

import java.util.Scanner;
import java.util.logging.ConsoleHandler;

import static org.assertj.core.api.Assertions.assertThat;

public class GameControllerTest {

    @Test
    void input_입력값_받기() {
        String result = Console.readLine();

    }

    @Test
    void split_메서드로_주어진_값을_구분() {
        String input = "1,2";
        String[] result = input.split(",");

        assertThat(result).contains("2", "1");
        assertThat(result).containsExactly("1", "2");
    }
}
