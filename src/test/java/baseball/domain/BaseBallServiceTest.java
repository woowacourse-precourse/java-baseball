package baseball.domain;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BaseBallServiceTest {

    BaseBallService baseBallService;

    @BeforeAll
    public void setUp(){
        baseBallService = new BaseBallServiceImpl();
    }

    @Nested
    class RandomNumberTest {
        @RepeatedTest(100)
        @Test
        void selectRandomNumbers() {

            //when
            List<Integer> numbers = baseBallService.selectRandomNumbers();

            //then
            assertDoesNotThrow(() -> {
                validateNumbers(numbers);
            });
        }

        void validateNumbers(List<Integer> numbers) {

            if (numbers.size() != 3)
                throw new IllegalArgumentException();

            for (int num : numbers) {
                if (num < 1 || num > 9)
                    throw new IllegalArgumentException();
            }
        }
    }

    @Nested
    class verifyingTest{

        @Test
        void 입력받은_문자_검증_예외처리_테스트(){
            assertThrows(IllegalArgumentException.class,()->{

            });
        }
    }

//
//    List<Integer> stringToStringList(String str);
//    void compareNumbers(List<Integer> numbers);
//    int inputQuestionRestart();
}