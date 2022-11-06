package baseball;

import java.io.*;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerNumberTest {

    @Test
    void 유효하지않은_플레이어수_숫자아닌경우_예외발생_테스트(){
        //given
        String input = "120"; //"가나다" ,"ABC" ,"012", "1234"
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> Application.getPlayerNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유효하지않은_플레이어수_세자리아닌경우_테스트(){

    }
}