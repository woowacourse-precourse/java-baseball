package baseball;

import baseball.number.computer.ComputerNumbers;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

public class RandomsTest {

    @Test
    void RandomsNumber() {
        System.out.println("Number : "+Randoms.pickNumberInRange(1,9));
    }

    @Test
    void generateRandomNumber() {
        ComputerNumbers computerNumbers = new ComputerNumbers();
        System.out.println(computerNumbers.generateRandomNumbers());
    }
}
