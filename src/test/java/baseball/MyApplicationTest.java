package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MyApplicationTest {

    @Test
    void checkScoreInUserInput() {
        List<Integer> computer=List.of(1,2,3);
        boolean result=Application.checkScoreInUserInput("123", computer);
        assertThat(result).isEqualTo(true);
    }

    @Test
    void makeRandomNumber() {
        List<Integer> result= Application.makeRandomNumber();
        assertThat(result).hasSize(3);
    }

    @Test
    void checkErrorInUserInput() {
        boolean result=Application.checkErrorInUserInput("123");
        assertThatThrownBy(() -> Application.checkErrorInUserInput("1234"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(result).isEqualTo(true);
    }
}