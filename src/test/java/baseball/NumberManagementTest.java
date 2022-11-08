package baseball;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberManagementTest {

    @Test
    void sizeTestRandomNumberMake() {
        int loopFrequency=4;
        List<Integer> randomList = NumberManagement.randomNumberMake(loopFrequency);

        assertEquals(randomList.size(),4);
    }

    @Test
    void duplicateTestRandomNumberMake(){
        int loopFrequency=4;
        List<Integer> randomList = NumberManagement.randomNumberMake(loopFrequency);

        for (Integer checkNumber:
                randomList) {
            for (int i = 0; i < randomList.size(); i++) {
                assertEquals(Collections.frequency(randomList, checkNumber),1);
            }
        }
    }
}