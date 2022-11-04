package baseball;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberComparatorTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void restore() {
        System.setOut(System.out);
        output.reset();
    }

    @Test
    void isUserWin_메서드로_정답_검사() {
        int numberSize = 3;
        int startInclusive = 1;
        int endInclusive = 9;

        NumberComparator numberComparator = new NumberComparator(numberSize);
        Computer computer = new Computer(numberSize, startInclusive, endInclusive);
        computer.makeNewNumbers();

        StringBuilder numberBuilder = new StringBuilder();
        for (int index = 0; index < numberSize; index++) {
            numberBuilder.append(computer.getNumber(index));
        }

        User user = new User();
        user.makeNewNumbers(numberBuilder.toString());

        boolean isUserWin = numberComparator.isUserWin(user, computer);
        assertThat(isUserWin).isEqualTo(true);
    }

    @Test
    void isUserWin_메서드로_오답_검사() {
        int numberSize = 3;
        int startInclusive = 1;
        int endInclusive = 9;

        NumberComparator numberComparator = new NumberComparator(numberSize);
        Computer computer = new Computer(numberSize, startInclusive, endInclusive);
        computer.makeNewNumbers();

        StringBuilder numberBuilder = new StringBuilder();
        for (int index = 0; index < numberSize; index++) {
            int number = computer.getNumber(index);
            number = (number + 1) % 10;
            numberBuilder.append(number);
        }

        User user = new User();
        user.makeNewNumbers(numberBuilder.toString());

        boolean isUserWin = numberComparator.isUserWin(user, computer);
        assertThat(isUserWin).isEqualTo(false);
    }

    @Test
    void isUserWin_메서드로_스트라이크_개수_검사() {
        int numberSize = 3;
        int startInclusive = 1;
        int endInclusive = 3;

        NumberComparator numberComparator = new NumberComparator(numberSize);
        Computer computer = new Computer(numberSize, startInclusive, endInclusive);
        computer.makeNewNumbers();

        StringBuilder numberBuilder = new StringBuilder();
        for (int index = 0; index < numberSize; index++) {
            int number = computer.getNumber(index);
            if (index == 1) {
                number += 3;
            }
            numberBuilder.append(number);
        }

        User user = new User();
        user.makeNewNumbers(numberBuilder.toString());

        numberComparator.isUserWin(user, computer);

        String expectedText = "2스트라이크";
        assertThat(output.toString().contains(expectedText)).isEqualTo(true);
    }

    @Test
    void isUserWin_메서드로_볼_검사() {
        int numberSize = 3;
        int startInclusive = 1;
        int endInclusive = 3;

        NumberComparator numberComparator = new NumberComparator(numberSize);
        Computer computer = new Computer(numberSize, startInclusive, endInclusive);
        computer.makeNewNumbers();

        StringBuilder numberBuilder = new StringBuilder();
        for (int index = 0; index < numberSize; index++) {
            int number = computer.getNumber(index);
            number += 2;
            numberBuilder.append(number);
        }

        User user = new User();
        user.makeNewNumbers(numberBuilder.toString());

        numberComparator.isUserWin(user, computer);

        String expectedText = "1볼";
        assertThat(output.toString().contains(expectedText)).isEqualTo(true);
    }

    @Test
    void isUserWin_메서드로_스트라이크와_볼_개수_검사() {
        int numberSize = 3;
        int startInclusive = 1;
        int endInclusive = 3;

        NumberComparator numberComparator = new NumberComparator(numberSize);
        Computer computer = new Computer(numberSize, startInclusive, endInclusive);
        computer.makeNewNumbers();

        StringBuilder numberBuilder = new StringBuilder();
        for (int index = 0; index < numberSize; index++) {
            int number = computer.getNumber(index);
            if (number > 1) {
                number += 1;
            }
            numberBuilder.append(number);
        }

        User user = new User();
        user.makeNewNumbers(numberBuilder.toString());

        numberComparator.isUserWin(user, computer);

        String expectedText = "1볼 1스트라이크";
        assertThat(output.toString().contains(expectedText)).isEqualTo(true);
    }
}
