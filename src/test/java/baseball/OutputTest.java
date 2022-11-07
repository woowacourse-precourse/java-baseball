package baseball;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class OutputTest {
    Output output;

    @Test
    void judgeResultTest() {
        output = new Output();
        ArrayList<Integer> checkAnswerNumList = new ArrayList<>();
        ArrayList<Integer> checkPlayerNumList = new ArrayList<>();

        checkAnswerNumList.add(7);
        checkAnswerNumList.add(1);
        checkAnswerNumList.add(3);

        checkPlayerNumList.add(1);
        checkPlayerNumList.add(2);
        checkPlayerNumList.add(3);

        String result = "1볼 1스트라이크";
        assertEquals(result, output.judgeResult(checkAnswerNumList, checkPlayerNumList));
    }
}
