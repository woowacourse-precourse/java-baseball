package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class UserTest {

    private static User user;

    @BeforeAll
    static void initAll() {
        user = new User();
    }

    @Test
        // 입력을 제대로 받았는지 확인
    void 문자_입력_테스트() throws Exception {
        //given
        User user = new User();
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        // when
        int result = user.getInputAllRightNumOfUser();
        // then
        assertThat(result).isEqualTo(123);
    }

//    @Test
//    void 문자열을_숫자로_변환_case_1() {
//        User user = new User();
//        int result = user.parseIntFromStr("123");
//        assertThat(result).isEqualTo(123);
//    }

//    @Test
//    void 입력_각각의_숫자가_같은가_case_1() {
//        User user = new User();
//        String[] arr = new String[]{"123", "234", "345", "456", "678", "789"};
//        List<Boolean> resultList = new ArrayList<>();
//        for (String str : arr) {
//            resultList.add(user.isValidNumOfIndividually(str));
//        }
//        assertThat(resultList).allMatch((boo) -> {
//            return boo.equals(true);
//        });
//    }

//    @Test
//    void 입력_각각의_숫자가_같은가_case_2() {
//        User user = new User();
//        String[] arr = new String[]{"112", "121", "211", "111", "556", "565", "655", "555"};
//        List<Boolean> resultList = new ArrayList<>();
//        for (String str : arr) {
//            resultList.add(user.isValidNumOfIndividually(str));
//        }
//        assertThat(resultList).allMatch((boo) -> {
//            return boo.equals(false);
//        });
//    }

//    @Test
//    void 입력값이_양수인지_체크() {
//        User user = new User();
//        assertThrows(IllegalArgumentException.class, () -> {
//            user.isValidPositiveInt(-111);
//        });
//    }
}
