package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    Computer computer = new Computer();

    @Test
    void numbers가_세자리_숫자형식인가() {
        assertThat(computer.getNumbers().length()).isEqualTo(3);
    }
}