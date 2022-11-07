package baseball.domain;

import baseball.utils.NumberValidator;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComputerTest {

    Computer computer;

    @BeforeEach
    void init() {
        computer = new Computer();
    }

    @Test
    void 컴퓨터_숫자_통과() {
        List<Integer> computerNumbers = computer.getComputerNumbers();
        String result = computerNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
        Assertions.assertThatNoException().isThrownBy(() -> NumberValidator.validate(result));
    }

}