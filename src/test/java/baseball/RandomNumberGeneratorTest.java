package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RandomNumberGeneratorTest {
    RandomNumberGenerator randomNumberGenerator;

    @BeforeEach
    void setup(){
        randomNumberGenerator =new RandomNumberGenerator();
    }

    @Test
    void setBaseballNumList_랜덤하게_생성된_숫자리스트_규칙이_맞는지(){
        assertThat(randomNumberGenerator.getRandomNumber().length()).isEqualTo(3);
        for(int i=0; i<3; i++){
            assertThat(Character.getNumericValue(randomNumberGenerator.getRandomNumber().charAt(i))).isBetween(1, 9);
        }
        String[] s=randomNumberGenerator.getRandomNumber().split("");
        List<String> numberList=new ArrayList<String>(Arrays.asList(s));
        for(int i=0; i< numberList.size(); i++){
            assertThat(Collections.frequency(numberList, numberList.get(i))).isEqualTo(1);
        }
    }
}