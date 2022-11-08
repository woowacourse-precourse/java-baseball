package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class NumCreatorTest {
    @RepeatedTest(10)
    @DisplayName("랜덤 생성된 문자열의 길이가 3이고 중복이 없으며 1-9만 포함")
    void create_test() {
        NumCreator numCreator = new NumCreator();
        String createdNum = numCreator.create(3);
        assertThat(createdNum).containsPattern("[1-9]{3}");

        String distincted = Arrays.stream(createdNum.split(""))
                .distinct()
                .collect(Collectors.joining());
        assertThat(distincted.length()).isEqualTo(3);
    }
}
