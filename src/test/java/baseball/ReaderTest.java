package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ReaderTest {
    @Test
    public void readIntTest() {
        assertThat(new MockReaderReturn1().readInt(1, 2)).isEqualTo(1);
    }

    @Test
    public void minTest() {
        assertThat(new MockReaderReturn1().readInt(1, 10)).isEqualTo(1);
    }

    @Test
    public void maxTest() {
        assertThat(new MockReaderReturn1().readInt(0, 1)).isEqualTo(1);
    }

    @Test
    @DisplayName("min,max 둘다 불만족")
    public void errorTest1() {
        assertThatThrownBy(() -> new MockReaderReturn1().readInt(0, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("min>max인 경우")
    public void errorTest2() {
        assertThatThrownBy(() -> new MockReaderReturn1().readInt(1, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("readInt()에서 에러가 날떄")
    public void errorTest3() {
        assertThatThrownBy(() -> new MockReaderReturnError().readInt(0, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

}