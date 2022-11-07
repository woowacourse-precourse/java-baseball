package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.Hint;
import baseball.service.HintService;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class HintTest {
    @Test
    @Order(1)
    void 힌트_객체_정상_생성() {
        List<Integer> userNumbers = List.of(1,2,3);
        List<Integer> computerNumbers = List.of(2,3,4);

        assertThat(HintService
                .generate(userNumbers, computerNumbers))
                .isInstanceOf(Hint.class);
    }

    @Test
    @Order(2)
    void 힌트_정답_확인() {
        List<Integer> userNumbers = List.of(2,3,4);
        List<Integer> computerNumbers = List.of(2,3,4);

        Hint hint = HintService.generate(userNumbers, computerNumbers);

        assertThat(HintService.isAnswer(hint))
                .isEqualTo(true);
    }

    @Test
    @Order(3)
    void 힌트_출력_2볼() {
        List<Integer> userNumbers = List.of(1,2,3);
        List<Integer> computerNumbers = List.of(2,3,4);

        Hint hint = HintService.generate(userNumbers, computerNumbers);

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        HintService.printHint(hint);

        final String hintMessage = "2볼\n";

        assertThat(hintMessage).isEqualTo(out.toString());
    }

    @Test
    @Order(4)
    void 힌트_출력_1스트라이크_1볼() {
        List<Integer> userNumbers = List.of(1,2,3);
        List<Integer> computerNumbers = List.of(3,2,4);

        Hint hint = HintService.generate(userNumbers, computerNumbers);

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        HintService.printHint(hint);

        final String hintMessage = "1볼 1스트라이크\n";

        assertThat(hintMessage).isEqualTo(out.toString());
    }
}
