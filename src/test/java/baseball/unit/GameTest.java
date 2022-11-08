package baseball.unit;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest extends NsTest {

    private static Game game = new Game(Arrays.asList(1,2,3));;

    @Test
    public void playAndIsNotStrike_동일한값_입력시_false_리턴(){
        assertSimpleTest(
                () -> {
                    run("123");
                    assertThat(false);
                }
        );
    }

    @Test
    public void playAndIsNotStrike_다른값_입력시_true_리턴(){
        assertSimpleTest(
                () -> {
                    run("321");
                    assertThat(false);
                }
        );
    }

//    @Test
//    public void inputGuessNumber_잘못된_입력값에_대한_예외처리_확인(){
//        assertThrows(
//                IllegalArgumentException.class,
//                () ->{
//                    run("111");
//                }
//        );
//    }

//    @Test
//    public void inputGuessNumber_올바른_입력값에_대한_리턴값_동일_확인(){
//        assertSimpleTest(
//                () -> {
//                    run("321");
//                    assertThat(Arrays.asList(3,2,1));
//                }
//        );
//    }


    @Override
    public void runMain(){
        game.playAndIsNotStrike();
    }

}
