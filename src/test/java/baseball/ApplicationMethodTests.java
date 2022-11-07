package baseball;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ApplicationMethodTests {

    @Test
    @DisplayName("computer 숫자 셋팅 기능 크기 테스트")
    public void setAnswerNumberTest1(){
        List<Integer> computer = Application.setAnswerNumber();

        assertThat(computer.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("computer 숫자 셋팅 기능 숫자 테스트")
    public void setAnswerNumberTest2(){
        List<Integer> computer = Application.setAnswerNumber();

        computer.forEach( number -> {
            assertThat(number).isGreaterThanOrEqualTo(0);
            assertThat(number).isLessThanOrEqualTo(9);
        });
    }

//    @Test
//    @DisplayName("사용자 입력 기능 null 유효성 테스트")
//    public void userInputNumberTest1(){
//
//        String input = Application.userInputNumber(new ByteArrayInputStream("123".getBytes()));
//
//        assertThat(input).isNotNull();
//    }
//
//    @Test
//    @DisplayName("사용자 입력 기능 숫자 유효성 테스트")
//    public void userInputNumberTest2(){
//        String input = Application.userInputNumber(new ByteArrayInputStream("123".getBytes()));
//
//        for(char c : input.toCharArray()){
//            assertThat(c).isGreaterThanOrEqualTo('0');
//            assertThat(c).isLessThanOrEqualTo('9');
//        }
//
//        assertThrows(IllegalArgumentException.class, () -> {
//                    Application.userInputNumber(new ByteArrayInputStream("sss".getBytes()));
//                });
//    }
//
//    @Test
//    @DisplayName("사용자 입력 기능 길이 유효성 테스트")
//    public void userInputNumberTest3(){
//        String input = Application.userInputNumber(new ByteArrayInputStream("123".getBytes()));
//
//        assertThat(input.length()).isEqualTo(3);
//
//        assertThrows(IllegalArgumentException.class, () -> {
//            Application.userInputNumber(new ByteArrayInputStream("1234".getBytes()));
//        });
//    }
//
//    @Test
//    @DisplayName("사용자 입력에 따른 ball, strike count 기능 테스트")
//    public void countBallAndStrikeTest1(){
//
//        List<Integer> computer = new ArrayList<>();
//        computer.add(1);
//        computer.add(2);
//        computer.add(3);
//
//        Application.BaseBallPoint baseBallPoint = Application.countBallAndStrike(computer, "132");
//
//        assertThat(baseBallPoint.getStrike()).isEqualTo(1);
//        assertThat(baseBallPoint.getBall()).isEqualTo(2);
//    }
}
