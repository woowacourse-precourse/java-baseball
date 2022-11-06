package baseball.game;

import baseball.MessagePrinter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MessagePrinterTest {
    MessagePrinter messagePrinter = new MessagePrinter();
    @Test
    void 결과가_0볼_0스트라이크인_경우_낫싱_출력() {
        String resultMessage = messagePrinter.getResultMessage(0, 0);
        assertThat(resultMessage).isEqualTo("낫싱");
    }

    @Test
    void 결과가_n볼_0스트라이크인_경우_n볼_출력() {
        String resultMessage1 = messagePrinter.getResultMessage(1, 0);
        String resultMessage2 = messagePrinter.getResultMessage(2, 0);
        String resultMessage3 = messagePrinter.getResultMessage(3, 0);
        String resultMessage4 = messagePrinter.getResultMessage(4, 0);

        assertThat(resultMessage1).isEqualTo("1볼");
        assertThat(resultMessage2).isEqualTo("2볼");
        assertThat(resultMessage3).isEqualTo("3볼");
        assertThat(resultMessage4).isEqualTo("4볼");
    }

    @Test
    void 결과가_0볼_m스트라이크인_경우_m스트라이크_출력() {
        String resultMessage1 = messagePrinter.getResultMessage(0, 1);
        String resultMessage2 = messagePrinter.getResultMessage(0, 2);
        String resultMessage3 = messagePrinter.getResultMessage(0, 3);
        String resultMessage4 = messagePrinter.getResultMessage(0, 4);

        assertThat(resultMessage1).isEqualTo("1스트라이크");
        assertThat(resultMessage2).isEqualTo("2스트라이크");
        assertThat(resultMessage3).isEqualTo("3스트라이크");
        assertThat(resultMessage4).isEqualTo("4스트라이크");
    }

    @Test
    void 결과가_n볼_m스트라이크인_경우_n볼_m스트라이크_출력() {
        String resultMessage1 = messagePrinter.getResultMessage(4, 1);
        String resultMessage2 = messagePrinter.getResultMessage(3, 2);
        String resultMessage3 = messagePrinter.getResultMessage(2, 3);
        String resultMessage4 = messagePrinter.getResultMessage(1, 4);

        assertThat(resultMessage1).isEqualTo("4볼 1스트라이크");
        assertThat(resultMessage2).isEqualTo("3볼 2스트라이크");
        assertThat(resultMessage3).isEqualTo("2볼 3스트라이크");
        assertThat(resultMessage4).isEqualTo("1볼 4스트라이크");
    }
}
