package baseball;

import java.io.*;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlayerNumberTest {

//    @Test
//    void 유효하지않은_플레이어수_숫자아닌경우_예외발생_테스트(){
//        //given
//        String input = "1123"; //"가나다" ,"ABC" ,"012", "1234", "120" 오류
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//
//        assertThatThrownBy(() -> Application.getPlayerNumber())
//                .isInstanceOf(IllegalArgumentException.class);
//    }

    @Test
    void 유효하지않은_플레이어수__테스트(){
        List<Integer> input = List.of(1,1,2,3);
        assertThat(Application.isValidNumber(input)).isFalse();

    }
}