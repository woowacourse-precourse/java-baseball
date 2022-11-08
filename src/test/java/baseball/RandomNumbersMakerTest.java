package baseball;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumbersMakerTest {
    @Test
    void 랜덤_수를_만든다() {
        RandomNumbersMaker randomNumbersMaker = new RandomNumbersMaker();

        LinkedList<Integer> linkedList = randomNumbersMaker.makeRandomNumbers();

        int one = linkedList.get(0);
        int two = linkedList.get(1);
        int three = linkedList.get(2);

        assertThat(one).isNotEqualTo(two);
        assertThat(two).isNotEqualTo(three);
        assertThat(three).isNotEqualTo(one);
    }
}