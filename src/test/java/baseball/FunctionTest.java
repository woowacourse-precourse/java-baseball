package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static baseball.Application.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class FunctionTest {
@Nested
class 랜덤으로숫자를뽑기{
    @Test
    void CreateRandomNumber() {
        List<Integer> Number =
                new ArrayList<>();
        while (Number.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!Number.contains(randomNumber)) {
                Number.add(randomNumber);
                }
            }
        }
    }
    @Nested
    class 입력받은숫자를int배열로변환{
        @Test
        void ChangeUserNumber(){
            String num = "567";
            int UserChoiceNum[] = InputNumber(num);

        }
    }

    @Nested
    class 입력자릿수확인{
        @Test
        void CheckInputNum(){
            String num = "456";
            int[] SuccessNum = new int[]{4,5,6};
            String num1 = "45678";
            int[] UserChoiceNum = new int[3];
            int[] result = GoAndStop(num,UserChoiceNum);
            assertThatThrownBy(() -> Application.GoAndStop(num1,UserChoiceNum))
                    .isInstanceOf(IllegalArgumentException.class);

            assert ((result.length) == SuccessNum.length);

        }
    }

    @Nested
    class 볼{
        @Test
        void BallTest(){
            int user = 1;
            int com = 1;
            int ball = 0;
            int i = 1;
            int j = 0;
            ball = Ball(com,user,i,j);
            assertEquals(ball,1);
        }
    }

    @Nested
    class 스트라이크{
        @Test
        void StrikeTest(){
            int user = 1;
            int com = 1;
            int strike = 0;
            int i = 0;
            int j = 0;
            strike = Strike(com,user,i,j);
            assertEquals(strike,1);
        }
    }

    @Nested
    class 총연산{

        @Test
        void ResultTest1(){
            List<Integer> RandomNumber = List.of(0,2,1);
            int[] UserChoiceNum = new int[]{1,2,3};
            HashMap<String,Integer> map = new HashMap<>();
            map = BallStrike(RandomNumber,UserChoiceNum);
            assert (map.get("볼") == 1 && map.get("스트라이크") == 1);
        }
        @Test
        void ResultTest2(){
            List<Integer> RandomNumber = List.of(1,2,3);
            int[] UserChoiceNum = new int[]{1,2,3};
            HashMap<String,Integer> map = new HashMap<>();
            map = BallStrike(RandomNumber,UserChoiceNum);
            assertEquals(map.get("스트라이크"),3);
        }
    }
    @Nested
    class 스트라이크3번{
            @Test
            void StrikeTest1(){
            int Restart = 0;
            String choice = "2";
            InputStream in = new ByteArrayInputStream(choice.getBytes());
            System.setIn(in);
            assertEquals(1,Strike3());
        }

        @Test
        void StrikeTest2(){
            int Restart = 0;
            String choice = "1";
            InputStream in = new ByteArrayInputStream(choice.getBytes());
            System.setIn(in);
            assertEquals(0,Strike3());
        }
    }

    @Nested
    class Check{
        @Test
        void Result(){
            List<Integer> RandomNumber = List.of(3,1,2);
            int[] UserNum = new int[]{2,1,3};
            HashMap<String, Integer> result = BallStrike(RandomNumber, UserNum);
            int Ball = result.get("볼");
            int Strike = result.get("스트라이크");
            RandomNumber = CheckResult(RandomNumber,UserNum);
            assertEquals(RandomNumber,RandomNumber);
        }
    }
}
