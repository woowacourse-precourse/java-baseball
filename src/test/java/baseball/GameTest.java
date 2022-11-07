package baseball;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    private static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @AfterEach
    void resetOutputStream() {
        System.setOut(System.out);
        output.reset();
    }

    @Test
    void get_valid_user_input() {
        InputStream in = generateUserInput("123");
        System.setIn(in);
        List<Integer> testInput = new ArrayList<>(Arrays.asList(1, 2, 3));
        assertThat(Game.getUserInput()).isEqualTo(testInput);
    }

    @Test
    void end_game_invalid_input() {
        String compareResult = "게임 종료";

        System.setOut(new PrintStream(output));

        InputStream in = generateUserInput("111");
        System.setIn(in);
        Game.getUserInput();

        assertThat(output.toString().trim())
                .contains(compareResult);
    }
}
