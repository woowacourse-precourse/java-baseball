package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HintTest {

    private Service service;

    @BeforeEach
    private void init() {
        service = new Service();
    }

    @DisplayName(value = "힌트 낫싱일 때 스트라이크 0 반환")
    @Test
    void nothing() throws Exception {
        List<Integer> answerList = Arrays.asList(1, 2, 3);
        List<Integer> inputList = Arrays.asList(4, 5, 6);
        assertThat(service.hint(answerList, inputList))
                .isEqualTo(0);
    }

    @DisplayName(value = "힌트 3볼일 때 스트라이크 0 반환")
    @Test
    void ball() throws Exception {
        List<Integer> answerList = Arrays.asList(1, 2, 3);
        List<Integer> inputList = Arrays.asList(3, 1, 2);
        assertThat(service.hint(answerList, inputList))
                .isEqualTo(0);
    }

    @DisplayName(value = "힌트 3스트라이크일 때 스트라이크 3 반환")
    @Test
    void strike() throws Exception {
        List<Integer> answerList = Arrays.asList(1, 2, 3);
        List<Integer> inputList = Arrays.asList(1, 2, 3);
        assertThat(service.hint(answerList, inputList))
                .isEqualTo(3);
    }

    @DisplayName(value = "힌트 1볼1스트라이크일 때 스트라이크 1 반환")
    @Test
    void each() throws Exception {
        List<Integer> answerList = Arrays.asList(1, 2, 3);
        List<Integer> inputList = Arrays.asList(2, 4, 3);
        assertThat(service.hint(answerList, inputList))
                .isEqualTo(1);
    }
}
