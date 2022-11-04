package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RoundTest {

    @ParameterizedTest
    @ValueSource(strings = {"123", "1245", "12","122"})
    void roundInputTest(String input) throws Exception {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Computer computer = new Computer();
        Round round = new Round(computer);

        round.startNewRound();
        round.playRound();
        round.startNewRound();
        assertThatThrownBy(() -> round.playRound())
                .isInstanceOf(IllegalArgumentException.class);
        round.startNewRound();
        assertThatThrownBy(() -> round.playRound())
                .isInstanceOf(IllegalArgumentException.class);
        round.startNewRound();
        assertThatThrownBy(() -> round.playRound())
                .isInstanceOf(IllegalArgumentException.class);
    }


}
