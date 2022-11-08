package baseball.util;

import baseball.domain.Hint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ViewTest {
    final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void printHint() {
        //given
        Hint ball3 = new Hint(0,3);
        Hint strike1Ball2 = new Hint(1,2);
        Hint strike3 = new Hint(3,0);
        Hint nothing = new Hint(0,0);
        List<Hint> hintTests = Arrays.asList(ball3, strike1Ball2, strike3, nothing);

        //when
        List<String> answer = Arrays.asList("3볼", "2볼 1스트라이크", "3스트라이크", "낫싱");

        //then
        for (int i=0; i<hintTests.size(); i++) {
            View.printHint(hintTests.get(i));
            assertThat(outputStream.toString().trim()).isEqualTo(answer.get(i));
            outputStream.reset();
        }
    }
}