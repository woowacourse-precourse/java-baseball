package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;


public class AnswerSheetTest{

    AnswerSheet answerSheet = new AnswerSheet();

    @Test
    void 예외_발생() {
        String input = "033";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assertions.assertThrows(IllegalArgumentException.class,()->answerSheet.getUserAnswer());
    }
    

}
