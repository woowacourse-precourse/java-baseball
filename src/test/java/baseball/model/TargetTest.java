package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TargetTest {
    private Target target = new Target();

    @BeforeEach
    void initTarget() {
        target.setTargetIntoZeroList();
    }

    @DisplayName("타겟을 리셋")
    @Test
    void reset() {
        target.reset();
        assertThat(target.get())
                .hasSize(3)
                .doesNotContain(0);
    }

    @DisplayName("타겟 값 반환")
    @Test
    void get() {
        List<Integer> result = Arrays.asList(0, 0, 0);
        assertThat(target.get()).isEqualTo(result);
    }

    @DisplayName("타겟을 0의 값만 가진 리스트로 설정")
    @Test
    void setTargetIntoZeroList() {
        target.reset();
        target.setTargetIntoZeroList();
        List<Integer> result = Arrays.asList(0, 0, 0);
        assertThat(target.get()).isEqualTo(result);
    }

    @DisplayName("타겟의 특정 인덱스에 해당하는 숫자를 랜덤으로 설정")
    @Test
    void setOneNumber() {
        target.setOneNumber(1);
        List<Integer> targetNumberList = target.get();
        assertThat(targetNumberList.get(1)).isNotEqualTo(0);
        assertThat(targetNumberList.get(0)).isEqualTo(0);
    }

    @DisplayName("숫자가 타겟에 이미 들어있는지 확인")
    @Test
    void checkIsNumberInTargetList() {
        target.reset();
        int firstNumberOfTarget = target.get().get(0);
        assertThat(target.checkIsNumberInTargetList(firstNumberOfTarget)).isEqualTo(true);
        assertThat(target.checkIsNumberInTargetList(0)).isEqualTo(false);
    }
}
