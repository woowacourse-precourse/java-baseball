package baseball.domain;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("컴퓨터 랜덤 숫자 생성 테스트")
class ComputerTest extends NsTest {
    Computer computer = new Computer();

    @BeforeEach
    void generateTestNumber() {
        computer.generateNumber();
    }

    @DisplayName("숫자 범위 테스트")
    @Test
    void rangeTest() {
        List<Integer> testList = computer.getNumbers();
        boolean result = testList.stream().allMatch(num -> (num >= 1 && num <= 9));

        assertThat(result).isTrue();
    }

    @DisplayName("숫자 길이 테스트")
    @Test
    void lengthTest() {
        List<Integer> testList = computer.getNumbers();
        int result = testList.size();

        assertThat(result).isEqualTo(3);
    }
    @DisplayName("숫자 중복 테스트")
    @Test
    void repeatTest() {
        List<Integer> testList = computer.getNumbers();
        assertThat(testList).doesNotHaveDuplicates();
    }

    @DisplayName("숫자 비교(스트라이크) 테스트")
    @Test
    void strikeTest() {
        computer.generateNumber();
        List<Integer> testList = computer.getNumbers();
        String numberToCompare = testList.toString().replaceAll("[^1-9]", "");
        Result result = computer.compareNumber(numberToCompare);

        assertThat(result.getStrikeCount()).isEqualTo(3);
    }

    @DisplayName("숫자 비교(볼) 테스트")
    @Test
    void ballTest() {
        computer.generateNumber();
        List<Integer> testList = computer.getNumbers();
        List<Integer> newList = new ArrayList<>();
        newList.addAll(testList.subList(1,3));
        newList.add(testList.get(0));
        String numberToCompare = newList.toString().replaceAll("[^1-9]", "");

        Result result = computer.compareNumber(numberToCompare);
        assertThat(result.getBallCount()).isEqualTo(3);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
