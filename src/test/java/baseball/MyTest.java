package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MyTest {

    @Test
    void computerBallsList의_길이와_유효성검사(){
        assertThat(Computer.makeBalls())
                .isNotEmpty()
                .doesNotContain(0)
                .size().isEqualTo(Computer.BallsLength);
    }

    @Test
    void computerBallsList가_중복값을_가지지는_않는지_알아본다(){
        for(int i=0; i<100; i++){
            List<Integer> computerBallsList = Computer.makeBalls();
            assertThat(computerBallsList.get(0))
                    .isNotEqualTo(computerBallsList.get(1))
                    .isNotEqualTo(computerBallsList.get(2));
        }
    }





}
