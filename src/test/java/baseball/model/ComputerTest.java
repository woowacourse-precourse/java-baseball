package baseball.model;

import static org.assertj.core.api.Assertions.*;
import baseball.controller.Valid;
import java.util.List;
import org.junit.jupiter.api.Test;

class ComputerTest {

    @Test
    void generateRandomNum_numList정확도테스트_10000번테스트() {
        //given
        Computer[] computer = new Computer[10000];
        //when
        int notValidTestCase=0;
        for (int i = 0; i < 10000; i++) {
            computer[i] = new Computer();
            List<Integer> generateRandomNumList = computer[i].generateRandomNumList();
            if(!Valid.isValidNumList(generateRandomNumList)){
                notValidTestCase++;
            }
        }
        //then
        assertThat(notValidTestCase).isEqualTo(0);
    }
}