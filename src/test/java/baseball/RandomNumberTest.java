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

    @Test
    public void getNumberOfStrikeCase1(){
        List<Integer> randomNumberList = randomNumber.getRandomNumberList();
        List<Integer> compareNumber = new ArrayList<>();
        compareNumber.add(0);
        compareNumber.add(randomNumberList.get(1));
        compareNumber.add(0);


        assertThat(randomNumber.getNumberOfStrike(compareNumber)).isEqualTo(1);
    }

    @Test
    public void getNumberOfStrikeCase2(){
        List<Integer> randomNumberList = randomNumber.getRandomNumberList();
        List<Integer> compareNumber = new ArrayList<>();
        compareNumber.add(randomNumberList.get(0));
        compareNumber.add(0);
        compareNumber.add(randomNumberList.get(2));

        assertThat(randomNumber.getNumberOfStrike(compareNumber)).isEqualTo(2);
    }

    @Test
    public void getNumberOfStrikeCase3(){
        List<Integer> randomNumberList = randomNumber.getRandomNumberList();
        List<Integer> compareNumber = new ArrayList<>();
        compareNumber.add(randomNumberList.get(0));
        compareNumber.add(randomNumberList.get(1));
        compareNumber.add(randomNumberList.get(2));

        assertThat(randomNumber.getNumberOfStrike(compareNumber)).isEqualTo(3);
    }
    @Test
    public void getNumberOfBallCase1(){
        List<Integer> randomNumberList = randomNumber.getRandomNumberList();
        List<Integer> compareNumber = new ArrayList<>();
        compareNumber.add(0);
        compareNumber.add(randomNumberList.get(0));
        compareNumber.add(0);


        assertThat(randomNumber.getNumberOfBall(compareNumber)).isEqualTo(1);
    }

    @Test
    public void getNumberOfBallCase2(){
        List<Integer> randomNumberList = randomNumber.getRandomNumberList();
        List<Integer> compareNumber = new ArrayList<>();
        compareNumber.add(randomNumberList.get(1));
        compareNumber.add(0);
        compareNumber.add(randomNumberList.get(0));

        assertThat(randomNumber.getNumberOfBall(compareNumber)).isEqualTo(2);
    }

    @Test
    public void getNumberOfBallCase3(){
        List<Integer> randomNumberList = randomNumber.getRandomNumberList();
        List<Integer> compareNumber = new ArrayList<>();
        compareNumber.add(randomNumberList.get(2));
        compareNumber.add(randomNumberList.get(2));
        compareNumber.add(randomNumberList.get(2));

        assertThat(randomNumber.getNumberOfBall(compareNumber)).isEqualTo(3);
    }
    @Override
    public void runMain() {
        Application.main(new String[]{
                }
        );
    }
}