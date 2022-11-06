package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        user.inputNumOfUser();
        int result = user.getNumSelecUser();
        // then
        assertThat(result).isEqualTo(123);
    }

    @Test
        // 실수 입력받을때
    void 문자_입력_예외_테스트_case_1() throws Exception {
        //given
        User user = new User();
        String input = "문자를입력";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        // when
        // then
        assertThrows(IllegalArgumentException.class,
            user::inputNumOfUser);
    }

    @Test
        // 음수 입력받을때
    void 문자_입력_예외_테스트_case_2() throws Exception {
        //given
        User user = new User();
        String input = "-3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        // when
        // then
        assertThrows(IllegalArgumentException.class,
            user::inputNumOfUser);
    }

    @Test
        // 길이가 초가 할때
    void 문자_입력_예외_테스트_case_3() throws Exception {
        //given
        User user = new User();
        String input = "1234";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        // when
        // then
        assertThrows(IllegalArgumentException.class,
            user::inputNumOfUser);
    }

    @Test
        // 입력한 숫자가 각각 자릿수가 같은지 확인
    void 문자_입력_예외_테스트_case_4() throws Exception {
        //given
        User user = new User();
        String input = "111";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        // when
        // then
        assertThrows(IllegalArgumentException.class,
            user::inputNumOfUser);
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
