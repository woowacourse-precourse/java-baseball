package baseball.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ComputerTest {

    @Test
    void 컴퓨터_숫자_생성() {
        Computer computer = new Computer();
        Assertions.assertEquals(3, computer.getComputerNumber().size());
    }
}