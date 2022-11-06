package baseball.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BaseBallServiceTest {

    BaseBallService baseBallService;

    @BeforeAll
    public void setUp(){
        baseBallService = new BaseBallServiceImpl();
    }

    @RepeatedTest(100)
    @Test
    void selectRandomNumbers() {

        //when
        List<Integer> numbers = baseBallService.selectRandomNumbers();

        //then
        assertDoesNotThrow(()->{
            validateNumbers(numbers);
        });
    }

     void validateNumbers(List<Integer> numbers){

        if(numbers.size() != 3)
            throw new IllegalArgumentException();

        for(int num : numbers){
            if(num <1 || num >9)
                throw new IllegalArgumentException();
        }
    }
}