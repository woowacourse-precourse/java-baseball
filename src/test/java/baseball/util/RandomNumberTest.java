package baseball.util;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.utils.RandomNumber;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class RandomNumberTest {

    @Test
    void randomIntegerListTest(){
        int size =3;
        int start = 1;
        int end = 9;
        List<Integer> list = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9));
        assertThat(RandomNumber.getRandomNumber(size,start,end)).hasSize(size).doesNotContain(0).containsAnyElementsOf(list);
    }
}
