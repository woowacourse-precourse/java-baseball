package baseball.compare;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ComparisonResultTest {

    ComparisonResult comparisonResult;

    @BeforeEach
    void setUp() {
        comparisonResult = new ComparisonResult();
    }

    @Test
    void getFrequency_메소드는_타입별_빈도수의_해시맵을_반환() {
        comparisonResult.add(ComparisonResultType.BALL);
        comparisonResult.add(ComparisonResultType.STRIKE);
        comparisonResult.add(ComparisonResultType.STRIKE);

        HashMap<ComparisonResultType, Integer> frequency = comparisonResult.getFrequency();

        assertThat(frequency.get(ComparisonResultType.BALL)).isEqualTo(1);
        assertThat(frequency.get(ComparisonResultType.STRIKE)).isEqualTo(2);
        assertThat(frequency.size()).isEqualTo(2);
    }

    @Test
    void getFrequency_메소드는_추가되지_않은_타입은_NULL() {
        comparisonResult.add(ComparisonResultType.BALL);

        HashMap<ComparisonResultType, Integer> frequency = comparisonResult.getFrequency();

        assertThat(frequency.get(ComparisonResultType.STRIKE)).isEqualTo(null);
    }
}
