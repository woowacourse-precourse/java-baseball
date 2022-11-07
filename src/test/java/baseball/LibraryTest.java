package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LibraryTest {
    public LibraryTest() {
        randoms();
    }

    @Test
    void randoms() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        Assertions.assertThat(randomNumber).isGreaterThan(1).isLessThan(9);
    }
}
