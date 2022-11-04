package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import static baseball.Application.*;

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
            String num1 = "45678";
            int UserChoiceNum[] = new int[3];
            boolean result = GoAndStop(num,UserChoiceNum);
            boolean result1 = GoAndStop(num1,UserChoiceNum);
            assert (result == true);
            assert (result1 == false);
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
            assert (ball == 1);
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
            assert (strike == 1);
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
            assert (map.get("홈런") == 1);
        }

    }
}
