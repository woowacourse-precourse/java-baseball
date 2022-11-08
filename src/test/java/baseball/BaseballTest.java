package baseball;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class BaseballTest {
    @Nested
    class FunctionList2{
        @Test
        void 랜덤숫자_생성시_3자리확인(){
            Integer RandomNumberLength = Application.getAnswerRandomNumber().size();
            assertThat(RandomNumberLength).isEqualTo(3);
        }
    }
    @Nested
    class FunctionList3{
        @Test
        void 숫자입력_테스트_정상1(){
            String inputString_Case1 = "123"; // 정상입력
            List<Integer> inputStringList = Application.getListByInputNumber(inputString_Case1);
            List<Integer> exNumberList = List.of(1,2,3);
            assertThat(exNumberList).isEqualTo(inputStringList);
        }
        @Test
        void 숫자입력_테스트_비정상1(){
            String inputString_Case2 = "abc"; // 숫자가 아닌 자료형 입력
            assertThatThrownBy(() -> Application.getListByInputNumber(inputString_Case2))
                    .isInstanceOf(IllegalArgumentException.class);
        }
        @Test
        void 숫자입력_테스트_비정상2(){
            String inputString_Case3 = "4567"; // 숫자이지만 3자리가 아닌 입력
            assertThatThrownBy(() -> Application.getListByInputNumber(inputString_Case3))
                    .isInstanceOf(IllegalArgumentException.class);
        }
        @Test
        void 숫자입력_테스트_비정상3(){
            String inputString_Case4 = "111"; // 숫자이고 3자리이지만 중복숫자 입력
            assertThatThrownBy(() -> Application.getListByInputNumber(inputString_Case4))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class FunctionList4{
        @Test
        void 정답확인_메세지_출력_테스트1(){
            List<Integer> com = Application.getAnswerRandomNumber();
            List<Integer> player = List.of(com.get(2),com.get(0),com.get(1));
            String onlyBall = Application.getAnswerCheckMessage(com,player);
            assertThat(onlyBall).isEqualTo("3볼");
        }
        @Test
        void 정답확인_메세지_출력_테스트2(){
            List<Integer> com = Application.getAnswerRandomNumber();
            List<Integer> player = List.of(com.get(0),com.get(1),com.get(2));
            String onlyStrike = Application.getAnswerCheckMessage(com,player);
            assertThat(onlyStrike).isEqualTo("3스트라이크");
        }
        @Test
        void 정답확인_메세지_출력_테스트3(){
            List<Integer> com = Application.getAnswerRandomNumber();
            List<Integer> player = List.of(com.get(2),com.get(1),com.get(0));
            String ballAndStrike = Application.getAnswerCheckMessage(com,player);
            assertThat(ballAndStrike).isEqualTo("2볼 1스트라이크");
        }
        @Test
        void 정답확인_메세지_출력_테스트4(){
            List<Integer> com = Application.getAnswerRandomNumber();
            List<Integer> player = List.of(-1,-1,-1);
            String ballAndStrike = Application.getAnswerCheckMessage(com,player);
            assertThat(ballAndStrike).isEqualTo("낫싱");
        }
    }
    @Nested
    class FunctionList5{
        @Test
        void HashMap_생성_기능_테스트1(){
            List<Integer> inputNumber = List.of(7,8,9);
            HashMap<Integer,Integer> map = Application.getNumberAndIndexByList(inputNumber);
            assertThat(map.get(inputNumber.get(0))).isEqualTo(0);
            assertThat(map.get(inputNumber.get(1))).isEqualTo(1);
            assertThat(map.get(inputNumber.get(2))).isEqualTo(2);
        }
        @Test
        void HashMap_생성_기능_테스트2(){
            List<Integer> inputNumber = List.of(9,8,7);
            HashMap<Integer,Integer> map = Application.getNumberAndIndexByList(inputNumber);
            assertThat(map.get(inputNumber.get(0))).isEqualTo(0);
            assertThat(map.get(inputNumber.get(1))).isEqualTo(1);
            assertThat(map.get(inputNumber.get(2))).isEqualTo(2);
        }
    }

    @Nested
    class FunctionList6{

    }

}
