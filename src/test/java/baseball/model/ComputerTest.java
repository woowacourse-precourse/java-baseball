package baseball.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {
    private Computer computer = new Computer();
    @Test
    public void 서로다른_3자리의_숫자(){
        computer.generateNumber();
        int[] generatedNumbers = computer.getNumbers();
        long distinctNumberCount = Arrays.stream(generatedNumbers).distinct().count();

        Assertions.assertEquals(distinctNumberCount, 3);
    }
}