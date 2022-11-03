package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.*;

public class AnswerSheetTest{

    AnswerSheet answerSheet = new AnswerSheet();

    @Test
    void 예외_발생() {
        String input = "033";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assertions.assertThrows(IllegalArgumentException.class,()->answerSheet.getUserAnswer());
    }

    @Test
    void 반복가능() {
        String input = "123\n456\n789";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        answerSheet.getUserAnswer();
        int result = answerSheet.userAnswer.get(2);

        assertThat(result).isEqualTo(9);
    }

}
