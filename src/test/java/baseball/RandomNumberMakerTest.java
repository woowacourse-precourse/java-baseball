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
        String computer = RandomNumberMaker.computer();
        assertThat(computer.length()).isEqualTo(EXPECTED_LENGTH);
    }


    public static boolean isDuplicated(String input) {
        int[] digits = input.chars().map(c -> c-'0').toArray();
        // 중복된 값이 있을 경우 True 반환
        HashSet tempSet = new HashSet();
        for (Integer integer : digits) {
            if (!tempSet.add(integer)) {
                return true;
            }
        }
        return false;
    }

    @Test
    void checkDuplicated() {
        String computer = RandomNumberMaker.computer();
        String duplicated = "444";
        String notDuplicated = "345";

        assertThat(RandomNumberMakerTest.isDuplicated(computer)).isFalse();
        assertThat(RandomNumberMakerTest.isDuplicated(duplicated)).isTrue();
        assertThat(RandomNumberMakerTest.isDuplicated(notDuplicated)).isFalse();
    }

}
