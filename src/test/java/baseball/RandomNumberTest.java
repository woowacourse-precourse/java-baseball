package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RandomNumberTest {
    
    @Test
    public void 넘겨준_count_만큼의_랜덤숫자가_생성되는지_확인() {
        RandomNumber randomNumber = new RandomNumber();
        int count = 5;
        List<Integer> randomNum = randomNumber.getRandomNum(count);

        Assertions.assertEquals(randomNum.size(), count);
    }

    @Test
    public void 최대길이_이상의_값을_넣었을_때() {
        RandomNumber randomNumber = new RandomNumber();
        int count = 20;
        List<Integer> randomNum = randomNumber
                .getRandomNum(count);

        Assertions.assertEquals(randomNum.size(), 9);
    }

    @Test
    public void 모든_숫자가_서로_다른_숫자인지_확인() {
        RandomNumber randomNumber = new RandomNumber();
        int count = 3;
        List<Integer> randomNum = randomNumber
                .getRandomNum(count);

        Assertions.assertNotEquals(randomNum.get(0), randomNum.get(1));
        Assertions.assertNotEquals(randomNum.get(0), randomNum.get(2));
        Assertions.assertNotEquals(randomNum.get(1), randomNum.get(2));
    }

}