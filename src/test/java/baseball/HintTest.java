package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class HintTest {
    Hint hint;
    @BeforeEach
    void setUp() {
        hint = new Hint();
    }

    @Test
    void hintTest(){
        List<Integer> user = List.of(1, 2, 3);
        List<Integer> computer = List.of(2, 1, 3);
        hint.getHint(user,computer);
        assertThat(hint.getBall()).isEqualTo(2);
        assertThat(hint.getStrike()).isEqualTo(1);
    }
}