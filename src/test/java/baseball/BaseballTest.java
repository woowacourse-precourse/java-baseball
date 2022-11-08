package baseball;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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

}
