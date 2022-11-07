package game;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import game.Converter;

public class ConverterTest {
    @Test
    void 잘못된_길이_테스트(){
        Converter converter = new Converter();
        assertThatThrownBy(() -> converter.convertToList("1234",3))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 잘못된_입력값_범위_테스트(){
        Converter converter = new Converter();
        assertThatThrownBy(() -> converter.convertToList("305",3))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 중복된_입력값_테스트(){
        Converter converter = new Converter();
        assertThatThrownBy(() -> converter.convertToList("595",3))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
