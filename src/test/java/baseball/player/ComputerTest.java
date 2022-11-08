package baseball.player;

import baseball.utils.IsCollection;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test; // @Test annotation
import org.junit.jupiter.api.BeforeEach; // @BeforeEach annotation

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;


public class ComputerTest {

    @RepeatedTest(100)
    void 서로_다른_3개의_숫자_생성(){

        Computer computer = new Computer();

        List<Integer> computerNumbers = computer.getComputerNumbers();

        for(int number : computerNumbers){
            assertThat(number).isBetween(1,9);
        }

        assertThat(IsCollection.isDuplication(computerNumbers)).isFalse();

        assertThat(IsCollection.isEqualToSetCount(computerNumbers,3)).isTrue();

    }

}
