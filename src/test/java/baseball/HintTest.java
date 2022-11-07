package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.Hint;
import baseball.service.HintService;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class HintTest {
    List<Integer> userNumbers;
    List<Integer> computerNumbers;

    @Test
    void 힌트_객체_정상_생성() {
        userNumbers = new ArrayList<>(Arrays.asList(1,2,3));
        computerNumbers = new ArrayList<>(Arrays.asList(2,3,4));

        assertThat(HintService
                .generate(userNumbers, computerNumbers))
                .isInstanceOf(Hint.class);
    }

    @Test
    void 힌트_정답_확인() {
        userNumbers = new ArrayList<>(Arrays.asList(2,3,4));
        computerNumbers = new ArrayList<>(Arrays.asList(2,3,4));

        Hint hint = HintService.generate(userNumbers, computerNumbers);

        assertThat(HintService.isAnswer(hint))
                .isEqualTo(true);
    }

    @Test
    void 힌트_출력_2볼() {
        userNumbers = new ArrayList<>(Arrays.asList(1,2,3));
        computerNumbers = new ArrayList<>(Arrays.asList(2,3,4));

        Hint hint = HintService.generate(userNumbers, computerNumbers);

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        HintService.printHint(hint);
        final String hintMessage = "2볼\n";

        assertThat(hintMessage).isEqualTo(out.toString());
    }

    @Test
    void 힌트_출력_1스트라이크_1볼() {
        userNumbers = new ArrayList<>(Arrays.asList(1,2,3));
        computerNumbers = new ArrayList<>(Arrays.asList(3,2,4));

        Hint hint = HintService.generate(userNumbers, computerNumbers);

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        HintService.printHint(hint);
        final String hintMessage = "1볼 1스트라이크\n";

        assertThat(hintMessage).isEqualTo(out.toString());
    }
}
