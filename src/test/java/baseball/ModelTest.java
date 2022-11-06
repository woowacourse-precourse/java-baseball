package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ModelTest {
    Model model;

    @BeforeEach
    void 모델_생성자() {
        model = new Model();
    }

    @Test
    void 정상값_확인() {
        model.setHumannumber("123");
        assertEquals("123", model.getHumannumber());
    }

    @Test
    void 틀린값_문자() {
        assertThrows(IllegalArgumentException.class, ()-> model.setHumannumber("12a"));
    }

    @Test
    void 틀린값_0포함() {
        assertThrows(IllegalArgumentException.class, ()-> model.setHumannumber("120"));
    }

    @Test
    void 틀린값_초과범위() {
        assertThrows(IllegalArgumentException.class, ()-> model.setHumannumber("1234"));
    }

    @Test
    void 틀린값_중복확인() {
        assertThrows(IllegalArgumentException.class, ()-> model.setHumannumber("122"));
    }
}
