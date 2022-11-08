package baseball.rule;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RuleTest {
    private Rule rule;
    private OutputStream out;

    @BeforeEach
    void init() {
        rule = new Rule();
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @Test
    void 출력_테스트1() {
        //given
        List<Integer> user = List.of(7, 2, 3);
        List<Integer> computer = List.of(2, 7, 3);
        String output = "2볼 1스트라이크";

        // when
        rule.check(user, computer);
        rule.showResult();

        // then
        assertThat(output).isEqualTo(out.toString().trim());
    }

    @Test
    void 출력_테스트2() {
        //given
        List<Integer> user = List.of(1, 2, 3);
        List<Integer> computer = List.of(4, 5, 6);
        String output = "낫싱";

        // when
        rule.check(user, computer);
        rule.showResult();

        // then
        assertThat(output).isEqualTo(out.toString().trim());
    }

    @Test
    void 출력_테스트3() {
        //given
        List<Integer> user = List.of(1, 2, 3);
        List<Integer> computer = List.of(1, 2, 3);
        String output = "3스트라이크";
        String gameClear = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

        // when
        rule.check(user, computer);
        rule.showResult();

        // then
        assertThat(out.toString()).contains(output, gameClear);
    }
}
