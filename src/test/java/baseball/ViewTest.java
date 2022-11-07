//package baseball;
//
//import org.junit.jupiter.api.Test;
//
//import java.io.ByteArrayInputStream;
//import java.io.InputStream;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThatThrownBy;
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//
//public class ViewTest {
//    @Test
//    void 숫자아닌입력값_예외발생_테스트(){
//        String input = "가나다"; // ,"ABC" ,"012", "1234", "120" 오류
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//        assertThatThrownBy(View::getUserInput)
//                .isInstanceOf(IllegalArgumentException.class);
//    }
//
//    @Test
//    void 다른명령값_예외발생_테스트() {
//        String input = "11"; // ,"ABC" ,"012", "1234", "120" 오류
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//        assertThatThrownBy(View::getExitInput)
//                .isInstanceOf(IllegalArgumentException.class);
//    }
//
//
//    //null값은 assertions 오류 발생함.
////    @Test
////    void 입력이_null일때_예외발생_테스트() {
////        String input = null;
////        InputStream in = new ByteArrayInputStream(input.getBytes());
////        System.setIn(in);
////        assertThatThrownBy(View::getUserInput)
////                .isInstanceOf(IllegalArgumentException.class);
////    }
//
//}
