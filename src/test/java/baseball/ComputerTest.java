package baseball;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ComputerTest {
    Computer computer = new Computer();

    @Test
    void 중복값_테스트() {
        computer.createComputerRandomNumber();

        assertTrue(computer.createComputerRandomNumber().get(0) != computer.createComputerRandomNumber().get(1));
        assertTrue(computer.createComputerRandomNumber().get(0) != computer.createComputerRandomNumber().get(2));
        assertTrue(computer.createComputerRandomNumber().get(1) != computer.createComputerRandomNumber().get(2));

        //

        // computerNumbers = computer.computerNumbers
        // originalSize = computerNumbers.size
        // uniqSize = computerNumbers.distinct().size
        // assertTrue(originalSize == uniqSize)
    }

    @Test
    void 숫자_범위_테스트() {
        computer.createComputerRandomNumber();
        assertTrue(computer.createComputerRandomNumber().get(0) >= 1 || computer.createComputerRandomNumber().get(0) <= 9);
        assertTrue(computer.createComputerRandomNumber().get(1) >= 1 || computer.createComputerRandomNumber().get(1) <= 9);
        assertTrue(computer.createComputerRandomNumber().get(2) >= 1 || computer.createComputerRandomNumber().get(2) <= 9);
    }

    @Test
    void 숫자_자릿수_테스트() {
        computer.createComputerRandomNumber();
        assertTrue(computer.createComputerRandomNumber().size() == 3);
    }
}