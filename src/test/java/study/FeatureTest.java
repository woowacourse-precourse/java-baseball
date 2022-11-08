package study;


import static baseball.Validation.validationCheck;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import baseball.Hint;
import baseball.Player;
import baseball.Print;
import java.util.Map;
import org.junit.jupiter.api.Test;



public class FeatureTest {


    @Test
    void 컴퓨터가_서로_다른_임의의_세자리_수_생성() {
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
    void 사용자가_올바른_값_입력() {

        String stringCheck = "alphabet";
        String asterRiskCheck = "!@#";
        String duplicateCheck = "111";
        String rangeCheck = "1000";

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            validationCheck(stringCheck);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            validationCheck(asterRiskCheck);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            validationCheck(duplicateCheck);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            validationCheck(rangeCheck);
        });

    }

    @Test
    public void 힌트와_출력_기능_점검() {
        //given
        int strike = Hint.getStrike();
        int ball = Hint.getBall();

        String result = Print.printResult();

        //when
        String strikeString = String.format("%d스트라이크", strike);
        String ballString = String.format("%d볼", strike);
        String ballAndStrike = String.format("%d볼 %d스트라이크", ball, strike);

        //then
        if ( strike > 0 ){      assertThat(strikeString).isEqualTo("1스트라이크");   }
        if ( ball > 0 ){      assertThat(ballString).isEqualTo("1볼");   }
        if ( strike > 0 && ball > 0 ){      assertThat(ballAndStrike).isEqualTo("1볼 1스트라이크");   }
    }


}
