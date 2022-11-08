package baseball;

import java.util.List;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class TestCode {

    @Test
    public static void checkLengthTest() {

        String longInput = "1234";
        assertThatThrownBy(() -> CheckException.checkLength(longInput, 3))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    public static void checkCharTest() {

        String notNumber = "1b3";
        assertThatThrownBy(() -> CheckException.checkChar(notNumber,'1','9'))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    public static void checkDupTest() {

        String dupInput = "112";
        assertThatThrownBy(() -> CheckException.checkLength(dupInput, 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public static void getStrikeCountTest(){
        List<Integer> computerInput = new ArrayList<>(
                List.of(1,3,5));
        List<Integer> playerInput = new ArrayList<>(
                List.of(1,2,5));

        int strikeCount = App.getStrikeCount(computerInput, playerInput);

        assertThat(strikeCount).isEqualTo(2);
    }

    @Test
    public static void getBallCountTest(){
        List<Integer> computerInput = new ArrayList<>(
                List.of(1,3,5));
        List<Integer> playerInput = new ArrayList<>(
                List.of(1,2,5));

        int ballCount = App.getBallCount(computerInput, playerInput);

        assertThat(ballCount).isEqualTo(1);
    }

    @Test
    public static void getResultTest(){
        int ballCount = 2;
        int strikeCount = 1;

        String result = App.getResult(ballCount, strikeCount);

        assertThat(result).isEqualTo("2볼 1스트라이크");
    }

}
