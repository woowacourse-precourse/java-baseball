package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberMakerTest {

    @Test
    void checkBallLength() {
        // 배열의 길이가 3
        final int EXPECTED_LENGTH = 3;
        ArrayList<Integer> computer = RandomNumberMaker.computer();
        System.out.println(computer);
        assertThat(computer).hasSize(EXPECTED_LENGTH);
    }


    public static boolean isDuplicated(ArrayList<Integer> input) {
        // 중복된 값이 있을 경우 True 반환
        HashSet tempSet = new HashSet();
        for (Integer integer : input) {
            if (!tempSet.add(integer)) {
                return true;
            }
        }
        return false;
    }

    @Test
    void checkDuplicated() {
        ArrayList<Integer> computer = RandomNumberMaker.computer();
        ArrayList<Integer> duplicated = new ArrayList<Integer>(Arrays.asList(4, 4, 4));
        ArrayList<Integer> notDuplicated = new ArrayList<Integer>(Arrays.asList(3, 4, 5));

        assertThat(RandomNumberMakerTest.isDuplicated(computer)).isFalse();
        assertThat(RandomNumberMakerTest.isDuplicated(notDuplicated)).isFalse();
        assertThat(RandomNumberMakerTest.isDuplicated(duplicated)).isTrue();
    }

}
