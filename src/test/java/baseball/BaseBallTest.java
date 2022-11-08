package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static baseball.Application.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BaseBallTest {

    @Test
    @DisplayName("랜덤 숫자 생성 테스트")
    public void randomNumbersGeneratorTest(){
        //given
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        //when
        int checker = 0;
        for(Integer a : computer){
            if(a<1||a>9) checker++;
        }
        if(computer.size()>3) checker++;

        //then
        assertThat(checker).isEqualTo(0);
    }

    @Test
    @DisplayName("입력받은 문자열 검증")
    public void validateInputStringTest(){
        //given
        String input = "1234";
        //when
        //then
        assertThatThrownBy(()->validateInputString(input)).isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("볼 체크")
    public void ballTest(){
        //when
        List<Integer> computer = List.of(1,2,3);
        List<Integer> user = List.of(4,5,6);

        //then
        Integer balls = checkBall(computer,user);

        //when
        Assertions.assertThat(balls).isEqualTo(0);
    }
    @Test
    @DisplayName("스트라이크 체크")
    public void strikeTest(){
        //when
        List<Integer> computer = List.of(1,2,3);
        List<Integer> user = List.of(1,2,3);

        //then
        Integer strike = checkStrike(computer,user);

        //when
        Assertions.assertThat(strike).isEqualTo(3);
    }


    @Test
    public void 문자열로부터_변환된_정수_리스트_검증(){
        //given
        String s = "456";
        String[] splits = s.split("");

        //when
        List<Integer> integers = changeStringArrToIntegerList(splits);
        List<Integer> integerList = List.of(4,5,6);

        //then
        assertThat(integers).isEqualTo(integerList);
    }





}
