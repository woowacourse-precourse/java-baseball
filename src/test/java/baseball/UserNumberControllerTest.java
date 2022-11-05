package baseball;

import static baseball.type.NumberType.NUMBER_SIZE;
import static org.assertj.core.api.Assertions.assertThat;

import baseball.service.UserNumberService;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class UserNumberControllerTest {
    @AfterEach
    void initailize() {
        UserNumberService.initialize();
    }
    @Test
    void 유저_숫자_갯수_검증() {
        String input = "123";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        List<Integer> userNumbers = UserNumberService.generate();
        int userNumbersSize = userNumbers.size();

        assertThat(userNumbersSize).isEqualTo(NUMBER_SIZE);
    }

    @Test
    void 유저_숫자_중복_여부_검증() {
        String input = "456";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        List<Integer> userNumbers = UserNumberService.generate();

        assertThat(userNumbers)
                .isEqualTo(userNumbers
                        .stream()
                        .distinct()
                        .collect(Collectors.toList()));
    }
}
