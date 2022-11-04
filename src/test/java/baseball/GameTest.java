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

    /**
     * 사용자가 입력한 값이 List 형태로 출력되는지 확인
     * @see InputValidationTest 사용자 입력값 유효성 검사 테스트
     */
    @Test
    void get_valid_user_input() {
        InputStream in = generateUserInput("123");
        System.setIn(in);
        List<Integer> testInput = new ArrayList<>(Arrays.asList(1, 2, 3));
        assertThat(Game.getUserInput()).isEqualTo(testInput);
    }

    /**
     * 사용자가 유효하지 않은 값을 입력했을 때 게임이 종료되는지 확인
     * @see InputValidationTest 사용자 입력값 유효성 검사 테스트
     */
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
