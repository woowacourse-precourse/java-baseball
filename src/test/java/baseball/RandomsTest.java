package baseball;

import baseball.utils.GenerateRandomNumber;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

public class RandomsTest {

    @Test
    void RandomsNumber() {
        System.out.println("Number : "+Randoms.pickNumberInRange(1,9));
    }

    @Test
    void generateRandomNumber() {
        GenerateRandomNumber generateRandomNumber = new GenerateRandomNumber();
        System.out.println(generateRandomNumber.generateRandomNumber());
    }
}
