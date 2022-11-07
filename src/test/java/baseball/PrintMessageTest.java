package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrintMessageTest {

    @Test
    void startMessage() {
        PrintMessage.startMessage();
        org.assertj.core.api.Assertions.assertThat(1).isEqualTo(2);
    }

    @Test
    void inputMessage() {
    }

    @Test
    void ballStrikeMessage() {
    }

    @Test
    void answerMessage() {
    }

    @Test
    void gameContinueMessage() {
    }
}