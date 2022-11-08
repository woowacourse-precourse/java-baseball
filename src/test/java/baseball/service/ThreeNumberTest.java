package baseball.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
        for (int num : number.getNumber()) {
            assertThat(dup.contains(num)).isFalse();
            dup.add(num);
        }
    }
}