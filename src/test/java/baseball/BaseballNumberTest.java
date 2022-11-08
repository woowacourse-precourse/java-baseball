package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballNumberTest {

    @Test
    void 생성된_숫자가_3자리수() {
        List<Integer> baseballNumber = BaseballNumber.create();
        assertThat(baseballNumber.size()).isEqualTo(3);
    }

    @Test
    void 각자리_숫자의_중복_여부_확인() {
        boolean hasSameNumber = false;
        List<Integer> baseballNumber = BaseballNumber.create();

        int onesPlace = baseballNumber.get(2);
        int tensPlace = baseballNumber.get(1);
        int hundredsPlace = baseballNumber.get(0);

        if (onesPlace == tensPlace) {
            hasSameNumber = true;
        }
        if (tensPlace == hundredsPlace) {
            hasSameNumber = true;
        }
        if (onesPlace == hundredsPlace) {
            hasSameNumber = true;
        }

        assertThat(hasSameNumber).isFalse();
    }
}
