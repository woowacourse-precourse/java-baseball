package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FeatureTest {

    @Test
    @DisplayName("다른 숫자 3개가 들어온 경우에만 성공")
    void 사용자_입력_테스트() {
        assertThrows(IllegalArgumentException.class,
                () -> Application.getUserAnswer("122"));
        ;

        assertThrows(IllegalArgumentException.class,
                () -> Application.getUserAnswer("1234"));
        ;

        assertThrows(IllegalArgumentException.class,
                () -> Application.getUserAnswer("1d2"));
        ;

        assertEquals(Application.getUserAnswer("123"), List.of(1,2,3));
    }
}
