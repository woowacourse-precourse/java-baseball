package baseball.hint;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HintTest {
    private Hint hint;

    @Test
    void 스트라이크2개_있는_경우(){
        List<Integer> computerNum = List.of(1,2,3);
        List<Integer> playerNum = List.of(1,2,7);
        hint = new Hint(computerNum, playerNum);

        assertThat(hint.getHint()).isEqualTo("2스트라이크");
    }
    
    @Test
    void 볼2개_있는_경우(){
        List<Integer> computerNum = List.of(1,2,3);
        List<Integer> playerNum = List.of(7,1,2);
        hint = new Hint(computerNum, playerNum);

        assertThat(hint.getHint()).isEqualTo("2볼 ");
    }

    @Test
    void 볼과_스트라이크가_있는_경우(){
        List<Integer> computerNum = List.of(1,2,3);
        List<Integer> playerNum = List.of(7,2,1);
        hint = new Hint(computerNum, playerNum);

        assertThat(hint.getHint()).isEqualTo("1볼 1스트라이크");
    }

}
