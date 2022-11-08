package baseball.view;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class OutputViewTest {
    OutputStream outputFromComputer() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        return out;
    }

    @Test
    void 게임결과_출력_테스트() {
        OutputStream out = outputFromComputer();
        OutputView.printResult(3, 0);
        assertThat(out.toString()).isEqualTo("3스트라이크 \n");

        out = outputFromComputer();
        OutputView.printResult(2, 1);
        assertThat(out.toString()).isEqualTo("1볼 2스트라이크 \n");

        out = outputFromComputer();
        OutputView.printResult(0, 2);
        assertThat(out.toString()).isEqualTo("2볼 \n");

        out = outputFromComputer();
        OutputView.printResult(0, 0);
        assertThat(out.toString()).isEqualTo("낫싱\n");
    }
}