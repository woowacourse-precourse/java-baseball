package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MyTest {
//    @BeforeEach
//    void initComputerNumber() {
//        Application application = new Application();
//        application.initComputerNumber();
//    }

    @Test
    void computerNumberSizeTest() {
        //given(준비)
        Application.initComputerNumber();
        List<Character> computerNumber = Application.computerNumber;
        //when(실행)
        
        //then(검증)
        Assertions.assertThat(computerNumber).size().isEqualTo(3);
    }

    @Test
    void computerNumberRangeTest() {
        //given(준비)
        Application.initComputerNumber();
        List<Character> computerNumber = Application.computerNumber;
        //when(실행)
        
        //then(검증)
        for (int i = 0; i < 3; i++) {
            Assertions.assertThat(computerNumber.get(i)).isBetween('1','9');
        }
    }

    @Test
    void checkStrike() {
        //given(준비)
        Application.computerNumber = List.of('1','2','3');

        //when(실행)
        int strikeCount = Application.checkStrike("456");

        //then(검증)
        Assertions.assertThat(strikeCount).isEqualTo(0);
    }

    


}
