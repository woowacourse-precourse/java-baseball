package study;

import baseball.RandomNumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ProdTest {

    /**
     * 컴퓨터가 임의의 난수 3개 생성
     * 임의의 난수 3개 확인하기
     */
    @Test
     void assertRandomNumberTest(){
        RandomNumberGenerator.generate();

        System.out.println(RandomNumberGenerator.randomNumberList);

        assertThat(RandomNumberGenerator.randomNumberList)
                .hasSize(3)
                .containsAnyElementsOf(List.of(1,2,3,4,5,6,7,8,9));
    }
}
