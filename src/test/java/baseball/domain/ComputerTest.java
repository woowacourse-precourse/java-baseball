package baseball.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ComputerTest extends NsTest {

    @Test
    void 임의의_난수가_생성되면_성공() throws NoSuchFieldException, IllegalAccessException {
        // given
        Computer computer = new Computer();
        
        Field field = computer.getClass().getDeclaredField("computerNumbers");
        field.setAccessible(true);

        //when
        computer.createRandomNumber();
        List<Integer> computerNumbers = (ArrayList<Integer>) field.get(computer);

        // then
        Assertions.assertThat(computerNumbers).isNotNull();
    }
    
    @Test
    void 숫자가_모두_다르면_낫싱을_반환한다() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("456", "789", "123", "2");
                    assertThat(output()).contains("낫싱", "낫싱");
                },
                1,2,3
        );
    }
    
    @Test
    void 숫자와_위치가_하나만_일치하면_1스트라이크를_반환한다() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("145", "729", "123", "2");
                    assertThat(output()).contains("1스트라이크", "1스트라이크");
                },
                1,2,3
        );
    }

    @Test
    void 하나의_숫자가_일치하지만_위치가_다르면_1볼을_반환한다() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("451", "378", "123", "2");
                    assertThat(output()).contains("1볼", "1볼");
                },
                1,2,3
        );
    }

    @Test
    void 두개의_숫자가_일치하고_그중_하나의_위치만_같다면_1볼_1스트라이크를_반환한다() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("134", "273", "123", "2");
                    assertThat(output()).contains("1볼 1스트라이크", "1볼 1스트라이크");
                },
                1,2,3
        );
    }

    @Test
    void 세개의_숫자와_위치가_모두_일치한다면_3스트라이크를_반환한다() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("123", "2");
                    assertThat(output()).contains("3스트라이크");
                },
                1,2,3
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
