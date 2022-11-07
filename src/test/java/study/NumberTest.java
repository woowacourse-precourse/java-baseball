package study;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.Player;
import java.util.Map;
import org.junit.jupiter.api.Test;



public class NumberTest {


    @Test
    public void 컴퓨터가_서로_다른_임의의_세자리_수_생성() throws Exception{
        //given
        Player player = new Player();
        Map<Integer, Integer> computerNumber = player.createComputerNumber();

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
}
