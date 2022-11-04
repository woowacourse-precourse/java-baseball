package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class UserTest {
    User user = new User();

    @Test
    void numberToListCheck() {
        List<Integer> userNumberList = user.numberToList(536);
        List<Integer> testList = Arrays.asList(5, 3, 6);
        assertIterableEquals(testList, userNumberList);
    }

    @Test
    void numberCheckTest() {
        boolean result = user.checkNumber(902);
        assertThat(result).isEqualTo(false);
    }

    @Test
    void checkTypeTest(){
        boolean result = user.checkType("sd");
        assertThat(result).isEqualTo(false);
    }


}