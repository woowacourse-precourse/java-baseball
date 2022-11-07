package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {
    
    @Test
    void makeNewNumbers_메서드로_컴퓨터_숫자_생성시_중복숫자_없는지_검사() {
        int numberSize = 3;
        int startInclusive = 1;
        int endInclusive = 9;

        Computer computer = new Computer(numberSize, startInclusive, endInclusive);
        computer.makeNewNumbers();

        List<Integer> numbers = new ArrayList<>();
        for (int index = 0; index < numberSize; index++) {
            numbers.add(computer.getNumber(index));
        }

        long duplicatedNumbers = numbers.stream().distinct().count();
        assertThat(duplicatedNumbers).isEqualTo(numberSize);
    }
}
