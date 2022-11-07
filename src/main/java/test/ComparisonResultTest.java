package test;

import java.util.HashMap;
import org.junit.jupiter.api.Test;
import view.Print;

import static org.assertj.core.api.Assertions.assertThat;

public class ComparisonResultTest {

    @Test
    void 낫싱() {
        HashMap<String, Integer> result = new HashMap<>();
        result.put("ball", 0);
        result.put("strike", 0);
        assertThat(Print.comparisonResult(result)).isFalse();
    }

    @Test
    void 투볼원스트라이크() {
        HashMap<String, Integer> result = new HashMap<>();
        result.put("ball", 2);
        result.put("strike", 1);
        assertThat(Print.comparisonResult(result)).isFalse();
    }

    @Test
    void 쓰리스트라이크(){
        HashMap<String, Integer> result = new HashMap<>();
        result.put("ball", 0);
        result.put("strike", 3);
        assertThat(Print.comparisonResult(result)).isTrue();
    }

}
