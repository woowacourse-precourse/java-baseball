package study;


import static baseball.Validation.validationCheck;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import baseball.AppConfig;
import baseball.Hint;
import baseball.Input;
import baseball.Player;
import baseball.Print;
import camp.nextstep.edu.missionutils.Console;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class FeatureTest {
    AppConfig appConfig = new AppConfig();

    @BeforeEach
    public void beforeEach() {

        Print print = appConfig.printResult();
        Hint hint = appConfig.loopHint();
        Player computerNumber = appConfig.createComputerNumber();
        Map<Integer, Integer> input = appConfig.inputUserNumber(Console.readLine());
    }

    @Test
    void 컴퓨터가_서로_다른_임의의_세자리_수_생성(){
        //given
        Player player = new Player();
        Map<Integer, Integer> computerNumber = Player.createComputerNumber();

        //when
        boolean assertSize = computerNumber.size() == 3;

        Integer valueByZero = computerNumber.get(0);
        Integer valueByOne = computerNumber.get(1);
        Integer valueByTwo = computerNumber.get(2);

        //then
        assertThat(assertSize).isEqualTo(true);
        assertThat(valueByZero).isNotEqualTo(valueByOne);
        assertThat(valueByZero).isNotEqualTo(valueByTwo);
        assertThat(valueByOne).isNotEqualTo(valueByTwo);

    }

   @Test
   void 사용자가_올바른_값_입력(){

       String stringCheck = "alphabet";
       String asterRiskCheck = "!@#";
       String duplicateCheck = "111";
       String rangeCheck = "1000";


       //then
       assertThrows(IllegalArgumentException.class, () -> {    validationCheck(stringCheck);    });
       assertThrows(IllegalArgumentException.class, () -> {    validationCheck(asterRiskCheck);    });
       assertThrows(IllegalArgumentException.class, () -> {    validationCheck(duplicateCheck);    });
       assertThrows(IllegalArgumentException.class, () -> {    validationCheck(rangeCheck);    });

   }

   @Test
   public void 입력_기능_올바른_동작() throws Exception{

       //given
       Input input = new Input();
       Map<Integer, Integer> userNumber = input.inputUserNumber("246");

       //when
       boolean assertSize = userNumber.size() == 3;
       Integer valueByZero = userNumber.get(0);
       Integer valueByOne = userNumber.get(1);
       Integer valueByTwo = userNumber.get(2);

       //then
       assertEquals(assertSize, true);
       assertThat(valueByZero).isNotEqualTo(valueByOne);
       assertThat(valueByZero).isNotEqualTo(valueByTwo);
       assertThat(valueByOne).isNotEqualTo(valueByTwo);

   }

   @Test
   public void 힌트_기능_개수_세기() throws Exception{
       //given
       Player computerNumber = appConfig.createComputerNumber();
       Map<Integer, Integer> userNumber = appConfig.inputUserNumber("123");
       Hint hint = new Hint();

       //when
       int strike = hint.getStrike();
       int ball = hint.getBall();
       int nothing = hint.getNothing();

       //then
       assertThat(strike>0).isEqualTo(true);
   }
}
