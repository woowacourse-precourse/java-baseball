package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import model.User;
import org.junit.jupiter.api.Test;

public class UserTest {

    // computer Test
    @Test
    void 문자열을_숫자로_변환_case_1() {
        User user = new User();
        int result = user.parseIntFromStr("123");
        assertThat(result).isEqualTo(123);
    }

    @Test
    void 입력_각각의_숫자가_같은가_case_1() {
        User user = new User();
        String[] arr = new String[]{"123", "234", "345", "456", "678", "789"};
        List<Boolean> resultList = new ArrayList<>();
        for (String str : arr) {
            resultList.add(user.isValidNumOfIndividually(str));
        }

        assertThat(resultList).allMatch((boo) -> {
            return boo.equals(true);
        });
    }
}
