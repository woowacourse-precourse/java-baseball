package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class InputValidationTest {
    private static GameController gameController;

    @BeforeAll
    static void setGameController()
    {
        gameController = new GameController();
    }

    @Test
    void 정상_케이스()
    {
        List<String> inputList = List.of("123","456","789");
        for(String input : inputList)
        {
            Assertions.assertThat(gameController.isValidUserInput(input)).isTrue();
        }
    }

    @Test
    void 숫자이외의_문자가_들어가면_false_를_반환()
    {
        List<String> inputList = List.of("ㅇ13","3v2","adf","!3%");
        for(String input : inputList)
        {
            Assertions.assertThat(gameController.isValidUserInput(input)).isFalse();
        }
    }

    @Test
    void 길이가_3이_아니면_false를_반환()
    {
        List<String> inputList = List.of("1234","6343","24","7","");
        for(String input : inputList)
        {
            Assertions.assertThat(gameController.isValidUserInput(input)).isFalse();
        }
    }

}
