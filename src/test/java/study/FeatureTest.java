package study;


import static baseball.Validation.validationCheck;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import baseball.AppConfig;
import baseball.Hint;
import baseball.Input;
import baseball.Player;
import baseball.Print;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class FeatureTest {

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();

        Print print = appConfig.printResult();
        Hint hint = appConfig.loopHint();
        Player computerNumber = appConfig.createComputerNumber();
        Input input = appConfig.inputUserNumber();
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
   public void 게임_기능은_조건대로_무한_재귀를_탈출() throws Exception{

       //given


       //when

       //then
   }
}
