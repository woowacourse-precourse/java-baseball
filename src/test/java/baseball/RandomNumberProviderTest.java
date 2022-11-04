package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberProviderTest {

    List<Integer> randomInts = RandomNumberProvider.generateRandomIntList();
    final int MAX_SIZE = 3;
    final int MAX_INT = 10;

    @Test
    @DisplayName("list size success test")
    void listSizeSuccessTest() {
        assertThat(randomInts.size()).isEqualTo(MAX_SIZE);
    }

    @Test
    @DisplayName("list int overlapping success test")
    void listOverlappingSuccessTest() {
        assertThat(randomInts.stream()
                .distinct().count()).isEqualTo(MAX_SIZE);
    }

    @Test
    @DisplayName("list int range success test")
    void intRangeSuccessTest() {
        assertThat(randomInts.stream()
                .filter(i -> i < MAX_INT).count()).isEqualTo(MAX_SIZE);
    }
}