package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomNumberTest extends NsTest {
    RandomNumber randomNumber;

    public RandomNumberTest() {
        this.randomNumber = new RandomNumber();
    }

    @Test
    public void constructorCase1(){
        List<Integer> duplicate = new ArrayList<>();
        List<Integer> randomNumberList = randomNumber.getRandomNumberList();
        if (randomNumberList.size() != 3)
            fail("size is not 3");
        for (Integer randomNumber : randomNumberList){
           if (randomNumber < 1 || randomNumber > 9)
               fail("out of range");
           if (duplicate.contains(randomNumber))
               fail("duplicate");
           duplicate.add(randomNumber);
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{
                }
        );
    }
}