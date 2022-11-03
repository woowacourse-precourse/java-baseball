package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void numberToListCheck() {
        User user = new User();
        List<Integer> userNumberList = user.numberToList(536);
        List<Integer> testList = Arrays.asList(5, 3, 6);
        assertIterableEquals(testList, userNumberList);
    }


}