package baseball.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class ThreeNumberTest {

    @DisplayName("서로 다른 세자리 수인지 테스트")
    @Test
    void generate() {
        //given
        ThreeNumber number = new ThreeNumber();
        Set<Integer> dup = new HashSet<>();
        //when
        number.generate();
        //then
        assertThat(number.getNumber())
                .doesNotHaveDuplicates();
    }
}