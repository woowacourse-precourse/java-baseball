package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CntBallAndStrikeTest extends NsTest {

    private final Application application = new Application();

    @Test
    void 볼이나_스트라이크가_없는_경우() throws IOException {
        List<Integer> computerNumber = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<String> userNumber = List.of("456".split(""));

        Application.CntBallAndStrike(computerNumber,userNumber);

        assertThat(output()).contains("낫싱");
    }

    @Test
    void 볼만_있는_경우() throws IOException {
        List<Integer> computerNumber = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<String> userNumber = List.of("345".split(""));

        Application.CntBallAndStrike(computerNumber,userNumber);

        assertThat(output()).contains("볼");
    }

    @Test
    void 스트라이크만_있는_경우() throws IOException {
        List<Integer> computerNumber = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<String> userNumber = List.of("145".split(""));

        Application.CntBallAndStrike(computerNumber,userNumber);

        assertThat(output()).contains("스트라이크");
    }

    @Test
    void 볼과_스트라이크가_있는_경우() throws IOException {
        List<Integer> computerNumber = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<String> userNumber = List.of("135".split(""));

        Application.CntBallAndStrike(computerNumber,userNumber);

        assertThat(output()).contains("볼","스트라이크");
    }

    @Test
    void 정답을_맞춘_경우() throws IOException {
        List<Integer> computerNumber = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<String> userNumber = List.of("123".split(""));

        Application.CntBallAndStrike(computerNumber,userNumber);

        assertThat(output()).contains("스트라이크","게임 종료");
    }

    @Override
    protected void runMain() {
        try {
            Application.main(new String[]{});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
