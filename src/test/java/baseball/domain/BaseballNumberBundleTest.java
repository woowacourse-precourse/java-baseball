package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballNumberBundleTest {

    @Test
    void getList() {
        BaseballNumberBundle numbers = new BaseballNumberBundle(1, 2, 3);

        List<Integer> target = new ArrayList<Integer>();
        target.add(1);
        target.add(2);
        target.add(3);
        assertThat(numbers.getList()).isEqualTo(target);
    }

    @Test
    void getReverseList() {
        BaseballNumberBundle numbers = new BaseballNumberBundle(1, 2, 3);

        List<Integer> target = new ArrayList<Integer>();
        target.add(3);
        target.add(2);
        target.add(1);
        assertThat(numbers.getReverseList()).isEqualTo(target);
    }

    @Test
    void addNumber() {
        BaseballNumberBundle numbers = new BaseballNumberBundle();
        numbers.addNumber(1);
        numbers.addNumber(3);
        numbers.addNumber(2);

        List<Integer> target = new ArrayList<Integer>();
        target.add(1);
        target.add(3);
        target.add(2);
        assertThat(numbers.getList()).isEqualTo(target);
    }
}