package baseball.presentation;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ViewTest {

    OutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setReader() {
        PrintStream reader = new PrintStream(outputStream);
        System.setOut(reader);
    }

    String output() {
        return outputStream.toString().trim();
    }

    @Test
    void printStart_게임_시작_메시지() {
        View view = View.getInstance(3);
        view.printStart();
        assertThat(output()).isEqualTo("숫자 야구 게임을 시작합니다.");
    }

    @Test
    void printPlayerTurn_플레이어_턴_전환_메시지() {
        View view = View.getInstance(3);
        view.printPlayerTurn();
        assertThat(output()).isEqualTo("숫자를 입력해주세요 :");
    }

    @Test
    void printNoting_낫싱_출력() {
        View view = View.getInstance(3);
        view.printNoting();
        assertThat(output()).isEqualTo("낫싱");
    }

    @Test
    void printCorrect_정답_메시지_출력() {
        View view = View.getInstance(3);
        view.printCorrect();

        StringBuilder answer = new StringBuilder();
        answer.append("3스트라이크").append(System.lineSeparator())
              .append("3개의 숫자를 모두 맞히셨습니다! 게임 종료").append(System.lineSeparator())
              .append("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        assertThat(output()).isEqualTo(answer.toString());
    }

    @Test
    void printBallAndStrike_볼만_있는_경우_출력() {
        View view = View.getInstance(3);
        view.printBallAndStrike(2, 0);
        assertThat(output()).isEqualTo("2볼");
    }

    @Test
    void printBallAndStrike_스트라이크만_있는_경우_출력() {
        View view = View.getInstance(3);
        view.printBallAndStrike(0, 2);
        assertThat(output()).isEqualTo("2스트라이크");
    }

    @Test
    void printBallAndStrike_볼과_스트라이크가_모두_있는_경우_출력() {
        View view = View.getInstance(3);
        view.printBallAndStrike(1, 2);
        assertThat(output()).isEqualTo("1볼 2스트라이크");
    }

}
