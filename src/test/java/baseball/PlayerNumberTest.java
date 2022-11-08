package baseball;

import java.io.*;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerNumberTest {
//    @Test
//    void 플레이어수_범위내의수_예외발생_테스트() {
//        String input = "120"; //"가나다" ,"ABC" ,"012", "1234"
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//
//        assertThatThrownBy(() -> Application.getPlayerNumber())
//                .isInstanceOf(IllegalArgumentException.class);
//    }

    @Test
    void 입력값_유효성_테스트() {
        List<Integer> input = List.of(1, 1, 2, 3);
        assertThat(Application.isValidNumber(input)).isFalse();
    }

}
